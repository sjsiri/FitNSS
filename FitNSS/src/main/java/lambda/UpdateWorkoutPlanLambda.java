package lambda;

import activity.requests.UpdateWorkoutPlanRequest;
import activity.results.UpdateWorkoutPlanResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class UpdateWorkoutPlanLambda
        extends LambdaActivityRunner<UpdateWorkoutPlanRequest, UpdateWorkoutPlanResult>
        implements RequestHandler<AuthenticatedLambdaRequest<UpdateWorkoutPlanRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<UpdateWorkoutPlanRequest> input, Context context) {
        return super.runActivity(
                () -> {
                    UpdateWorkoutPlanRequest unauthenticatedRequest = input.fromBody(UpdateWorkoutPlanRequest.class);
                    return input.fromUserClaims(claims ->
                            UpdateWorkoutPlanRequest.builder()
                                    .withWorkoutPlanId(unauthenticatedRequest.getWorkoutPlanId())
                                    .withWorkoutDayName(unauthenticatedRequest.getWorkoutDayName())
                                    .withUserId(claims.get("userId"))
                                    .build());
                },
                (request, serviceComponent) -> serviceComponent.provideUpdateWorkoutPlanActivity().handleRequest(request)
        );
    }
}
