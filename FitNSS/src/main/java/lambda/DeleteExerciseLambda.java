package lambda;

import activity.requests.DeleteExerciseRequest;
import activity.results.DeleteExerciseResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

import static utils.NullUtils.ifNull;

public class DeleteExerciseLambda extends LambdaActivityRunner<DeleteExerciseRequest, DeleteExerciseResult>
    implements RequestHandler<AuthenticatedLambdaRequest<DeleteExerciseRequest>, LambdaResponse> {

    /**
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return a LambdaResponse
     */
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<DeleteExerciseRequest> input, Context context) {
       DeleteExerciseRequest unauthenticatedRequest = input.fromPath(path -> DeleteExerciseRequest.builder()
               .withExerciseId(path.get("exerciseId"))
               .build());

       return super.runActivity(
               () -> input.fromUserClaims(claims ->
                       DeleteExerciseRequest.builder()
                               .withExerciseId(unauthenticatedRequest.getExerciseId())
                               .withUserId(claims.get("email"))
                               .build()),
               (request, serviceComponent) -> serviceComponent.provideDeleteExerciseActivity().handleRequest(request)
       );
    }
}
