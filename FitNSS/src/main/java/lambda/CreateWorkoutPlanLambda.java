package lambda;

import activity.requests.CreateWorkoutPlanRequest;
import activity.results.CreateWorkoutPlanResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateWorkoutPlanLambda extends LambdaActivityRunner<CreateWorkoutPlanRequest, CreateWorkoutPlanResult>
    implements RequestHandler<AuthenticatedLambdaRequest<CreateWorkoutPlanRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<CreateWorkoutPlanRequest> input, Context context) {
        return super.runActivity(
                () -> {
                    CreateWorkoutPlanRequest unauthenticatedRequest = input.fromBody(CreateWorkoutPlanRequest.class);
                    return input.fromUserClaims(claims ->
                            CreateWorkoutPlanRequest.builder()
                                    .withWorkoutDayName(unauthenticatedRequest.getWorkoutDayName())
                                    .withExercisesAdded(unauthenticatedRequest.getExercisesAdded())
                                    .withNumberOfSets(unauthenticatedRequest.getNumberOfSets())
                                    .withNumberOfReps(unauthenticatedRequest.getNumberOfReps())
                                    .withNumberOfWeights(unauthenticatedRequest.getNumberOfWeights())
                                    .withNotesBox(unauthenticatedRequest.getNotesBox())
                                    .withUserId(claims.get("email"))
                                    .build());
                },
                (request, serviceComponent) -> serviceComponent.provideCreateWorkoutPlanActivity().handleRequest(request)
        );
    }
}
