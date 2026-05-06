public abstract class DailyRoutineTemplate {
    
    public final void executeRoutine() {
        startRoutine();
        performMainTask();
        endRoutine();
    }

    private void startRoutine() {
        System.out.println("System: Starting automated daily routine...");
    }

    protected abstract void performMainTask();

    private void endRoutine() {
        System.out.println("System: Routine completed and logged in database.");
        System.out.println("-----------------------------------");
    }
}