public class ModuleAssignment {
    private final String assignmentName;
    private final int moduleNum;
    private final int maxPoints;
    private double earnedPoints;

    public ModuleAssignment (String assignmentName, int moduleNum, int maxPoints) {
        this.assignmentName = assignmentName;
        this.moduleNum = moduleNum;
        this.maxPoints = maxPoints;
        this.earnedPoints = 0.0;
    }

    public ModuleAssignment (String assignmentName, int moduleNum, double earnedPoints, int maxPoints) {
        this.assignmentName = assignmentName;
        this.moduleNum = moduleNum;
        this.maxPoints = maxPoints;
        this.earnedPoints = earnedPoints;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public int getModuleNum() {
        return moduleNum;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public double getEarnedPoints() {
        return earnedPoints;
    }

    public void setEarnedPoints(double newPoints) {
        if (newPoints >= 0.0) {
            earnedPoints = newPoints;
        }
    }

    @Override
    public String toString() {
        return "Points earned for Module " + moduleNum + " " + assignmentName + ": " + earnedPoints + "/" + maxPoints;
    }

    public static void main(String[] args) {
        ModuleAssignment module2PA = new ModuleAssignment("Programming Assignment", 3, 27.4, 30);
        System.out.println(module2PA);
    }
}