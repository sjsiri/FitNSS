package lambda;

import activity.requests.CreateExerciseRequest;
import activity.results.CreateExerciseResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateExerciseLambda extends LambdaActivityRunner<CreateExerciseRequest, CreateExerciseResult>
    implements RequestHandler<LambdaRequest<CreateExerciseRequest>, LambdaResponse> {

    /**
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return a LambdaResponse
     */
    @Override
    public LambdaResponse handleRequest(LambdaRequest<CreateExerciseRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromBody(CreateExerciseRequest.class),
                (request, serviceComponent) ->
                        serviceComponent.provideCreateExerciseActivity().handleRequest(request)
        );
    }
}
