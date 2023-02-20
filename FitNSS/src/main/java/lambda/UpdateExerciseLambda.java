package lambda;

import activity.requests.UpdateExerciseRequest;
import activity.results.UpdateExerciseResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

import static utils.NullUtils.ifNull;

public class UpdateExerciseLambda
        extends LambdaActivityRunner<UpdateExerciseRequest, UpdateExerciseResult>
        implements RequestHandler<AuthenticatedLambdaRequest<UpdateExerciseRequest>, LambdaResponse> {

    /**
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return a LambdaResponse
     */
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<UpdateExerciseRequest> input, Context context) {
        UpdateExerciseRequest updateExerciseRequest = input.fromBody(UpdateExerciseRequest.class);
        Map<String, String> path = ifNull(input.getPathParameters(), Map.of());
        updateExerciseRequest.setExerciseId(path.get("exerciseId"));

        return super.runActivity(
                () -> {
                    UpdateExerciseRequest unauthenticatedRequest = input.fromBody(UpdateExerciseRequest.class);
                    return input.fromUserClaims(claims ->
                            UpdateExerciseRequest.builder()
                                    .withExerciseId(updateExerciseRequest.getExerciseId())
                                    .withExerciseName(unauthenticatedRequest.getExerciseName())
                                    .withWorkingMuscle(unauthenticatedRequest.getWorkingMuscle())
                                    .withExerciseMovementGroup(unauthenticatedRequest.getExerciseMovementGroup())
                                    .withUserId(claims.get("email"))
                                    .build());
                },
                (request, serviceComponent) -> serviceComponent.provideUpdateExerciseActivity().handleRequest(request)
        );
    }
}
