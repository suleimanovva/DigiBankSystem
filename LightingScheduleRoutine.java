public class LightingScheduleRoutine extends DailyRoutineTemplate {
    @Override
    protected void performMainTask() {
        System.out.println("Action: Adjusting city lighting based on sunset/sunrise schedules.");
    }
}