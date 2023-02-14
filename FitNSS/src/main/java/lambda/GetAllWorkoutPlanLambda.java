package lambda;

import activity.requests.GetAllWorkoutPlanRequest;
import activity.results.GetAllWorkoutPlanResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetAllWorkoutPlanLambda extends LambdaActivityRunner<GetAllWorkoutPlanRequest, GetAllWorkoutPlanResult>
        implements RequestHandler<LambdaRequest<GetAllWorkoutPlanRequest>, LambdaResponse> {

    /**
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return a LambdaResponse
     */
    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetAllWorkoutPlanRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromPath(path -> GetAllWorkoutPlanRequest.builder()
                        .withWorkoutPlanId(path.get("workoutPlanId")).build()),
                (request, serviceComponent) -> serviceComponent.provideGetAllWorkoutPlanActivity().handleRequest(request)
        );
    }
}
