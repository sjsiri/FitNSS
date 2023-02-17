package lambda;

import activity.requests.CreateExerciseRequest;
import activity.results.CreateExerciseResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateExerciseLambda extends LambdaActivityRunner<CreateExerciseRequest, CreateExerciseResult>
    implements RequestHandler<AuthenticatedLambdaRequest<CreateExerciseRequest>, LambdaResponse> {

    /**
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return a LambdaResponse
     */
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<CreateExerciseRequest> input, Context context) {
        return super.runActivity(
                () -> {
                    CreateExerciseRequest unauthenticatedRequest = input.fromBody(CreateExerciseRequest.class);
                    return input.fromUserClaims(claims ->
                            CreateExerciseRequest.builder()
                                    .withExerciseName(unauthenticatedRequest.getExerciseName())
                                    .withWorkingMuscle(unauthenticatedRequest.getWorkingMuscle())
                                    .withExerciseMovementGroup(unauthenticatedRequest.getExerciseMovementGroup())
                                    .withUserId(claims.get("email"))
                                    .build());
                },
                (request, serviceComponent) -> serviceComponent.provideCreateExerciseActivity().handleRequest(request)
        );
    }
}
