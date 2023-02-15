package lambda;

import activity.requests.UpdateWorkoutPlanRequest;
import activity.results.UpdateWorkoutPlanResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

import static utils.NullUtils.ifNull;

public class UpdateWorkoutPlanLambda
        extends LambdaActivityRunner<UpdateWorkoutPlanRequest, UpdateWorkoutPlanResult>
        implements RequestHandler<AuthenticatedLambdaRequest<UpdateWorkoutPlanRequest>, LambdaResponse> {

    /**
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return a LambdaResponse
     */
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<UpdateWorkoutPlanRequest> input, Context context) {
        UpdateWorkoutPlanRequest updatedWorkoutIdRequest = input.fromBody(UpdateWorkoutPlanRequest.class);
        Map<String, String> path = ifNull(input.getPathParameters(), Map.of());
        updatedWorkoutIdRequest.setWorkoutPlanId(path.get("workoutPlanId"));


        return super.runActivity(
                () -> {
                    UpdateWorkoutPlanRequest unauthenticatedRequest = input.fromBody(UpdateWorkoutPlanRequest.class);
                    return input.fromUserClaims(claims ->
                            UpdateWorkoutPlanRequest.builder()
                                    .withWorkoutPlanId(updatedWorkoutIdRequest.getWorkoutPlanId())
                                    .withWorkoutDayName(unauthenticatedRequest.getWorkoutDayName())
                                    .withExercisesAdded(unauthenticatedRequest.getExercisesAdded())
                                    .withNumberOfSets(unauthenticatedRequest.getNumberOfSets())
                                    .withNumberOfReps(unauthenticatedRequest.getNumberOfReps())
                                    .withNumberOfWeights(unauthenticatedRequest.getNumberOfWeights())
                                    .withNotesBox(unauthenticatedRequest.getNotesBox())
                                    .withUserId(claims.get("email"))
                                    .build());
                },
                (request, serviceComponent) -> serviceComponent.provideUpdateWorkoutPlanActivity().handleRequest(request)
        );
    }
}
