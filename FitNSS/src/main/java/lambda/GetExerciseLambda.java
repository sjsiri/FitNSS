package lambda;

import activity.requests.GetExerciseRequest;
import activity.results.GetExerciseResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetExerciseLambda extends LambdaActivityRunner<GetExerciseRequest, GetExerciseResult> implements
        RequestHandler<LambdaRequest<GetExerciseRequest>, LambdaResponse> {

    /**
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return a LambdaResponse
     */
    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetExerciseRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromPath(path -> GetExerciseRequest.builder()
                        .withExerciseId(path.get("exerciseId"))
                        .build()),
                (request, serviceComponent) -> serviceComponent.provideGetExerciseActivity().handleRequest(request)
        );
    }
}
