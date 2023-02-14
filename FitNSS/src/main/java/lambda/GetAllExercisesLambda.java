package lambda;

import activity.requests.GetAllExercisesRequest;
import activity.results.GetAllExercisesResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetAllExercisesLambda extends LambdaActivityRunner<GetAllExercisesRequest, GetAllExercisesResult>
        implements RequestHandler<LambdaRequest<GetAllExercisesRequest>, LambdaResponse> {

    /**
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return a LambdaResponse
     */
    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetAllExercisesRequest> input, Context context) {
        return super.runActivity(() -> input.fromPath(path -> GetAllExercisesRequest.builder()
                .withExerciseId(path.get("exerciseId"))
                .build()), (request, serviceComponent) -> serviceComponent.provideGetAllExercisesActivity().handleRequest(request));
    }
}
