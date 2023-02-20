package lambda;

import activity.requests.DeleteWorkoutPlanRequest;
import activity.results.DeleteWorkoutPlanResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class DeleteWorkoutPlanLambda extends LambdaActivityRunner<DeleteWorkoutPlanRequest, DeleteWorkoutPlanResult>
    implements RequestHandler<AuthenticatedLambdaRequest<DeleteWorkoutPlanRequest>, LambdaResponse> {

    /**
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return a LambdaResponse
     */
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<DeleteWorkoutPlanRequest> input, Context context) {
        DeleteWorkoutPlanRequest unauthenticatedRequest = input.fromPath(path -> DeleteWorkoutPlanRequest.builder()
                .withWorkoutPlanId(path.get("workoutPlanId"))
                .build());

        return super.runActivity(
                () -> input.fromUserClaims(claims ->
                        DeleteWorkoutPlanRequest.builder()
                                .withWorkoutPlanId(unauthenticatedRequest.getWorkoutPlanId())
                                .withUserId(claims.get("email"))
                                .build()),
                (request, serviceComponent) -> serviceComponent.provideDeleteWorkoutPlanActivity().handleRequest(request)
        );
    }
}
