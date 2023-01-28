package lambda;

import activity.requests.UpdateExerciseRequest;
import activity.results.UpdateExerciseResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class UpdateExerciseLambda
        extends LambdaActivityRunner<UpdateExerciseRequest, UpdateExerciseResult>
        implements RequestHandler<LambdaRequest<UpdateExerciseRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(LambdaRequest<UpdateExerciseRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromBody(UpdateExerciseRequest.class),
                (request, serviceComponent) ->
                        serviceComponent.provideUpdateExerciseActivity().handleRequest(request)
        );
    }
}
