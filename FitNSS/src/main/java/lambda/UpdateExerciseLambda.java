package lambda;

import activity.requests.UpdateExerciseRequest;
import activity.results.UpdateExerciseResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

import static utils.NullUtils.ifNull;

public class UpdateExerciseLambda
        extends LambdaActivityRunner<UpdateExerciseRequest, UpdateExerciseResult>
        implements RequestHandler<LambdaRequest<UpdateExerciseRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(LambdaRequest<UpdateExerciseRequest> input, Context context) {
        return super.runActivity(
                () -> {
                    UpdateExerciseRequest updateExerciseRequest = input.fromBody(UpdateExerciseRequest.class);
                    Map<String, String> path = ifNull(input.getPathParameters(), Map.of());
                    updateExerciseRequest.setPathExerciseId(path.get("exerciseId"));
                    return updateExerciseRequest;
                },
                (request, serviceComponent) ->
                        serviceComponent.provideUpdateExerciseActivity().handleRequest(request)
        );
    }
}
