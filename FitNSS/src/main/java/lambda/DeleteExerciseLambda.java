package lambda;

import activity.requests.DeleteExerciseRequest;
import activity.results.DeleteExerciseResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class DeleteExerciseLambda extends LambdaActivityRunner<DeleteExerciseRequest, DeleteExerciseResult>
    implements RequestHandler<LambdaRequest<DeleteExerciseRequest>, LambdaResponse> {


    @Override
    public LambdaResponse handleRequest(LambdaRequest<DeleteExerciseRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromPath(path ->
                        DeleteExerciseRequest.builder()
                                .withExerciseId(path.get("exerciseId"))
                                .build()),
                (request, serviceComponent) -> serviceComponent.provideDeleteExerciseActivity().handleRequest(request)
        );
    }
}
