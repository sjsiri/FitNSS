package lambda;

import activity.requests.CreateExerciseRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateExerciseLambda extends LambdaActivityRunner<CreateExerciseRequest, src.main.java.activity.results.CreateExerciseResult>
    implements RequestHandler<LambdaRequest<CreateExerciseRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(LambdaRequest<CreateExerciseRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromBody(CreateExerciseRequest.class),
                (request, serviceComponent) ->
                        serviceComponent.provideCreateExerciseActivity().handleRequest(request)
        );
    }
}
