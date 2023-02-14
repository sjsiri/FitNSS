package lambda;

import activity.requests.GetWorkoutPlanRequest;
import activity.results.GetWorkoutPlanResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetWorkoutPlanLambda extends LambdaActivityRunner<GetWorkoutPlanRequest, GetWorkoutPlanResult> implements
        RequestHandler<LambdaRequest<GetWorkoutPlanRequest>, LambdaResponse> {

    /**
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return a LambdaResponse
     */
    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetWorkoutPlanRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromPath(path -> GetWorkoutPlanRequest.builder()
                        .withWorkoutPlanId(path.get("workoutPlanId"))
                        .build()),
                (request, serviceComponent) -> serviceComponent.provideGetWorkoutPlanActivity().handleRequest(request)
        );
    }
}
