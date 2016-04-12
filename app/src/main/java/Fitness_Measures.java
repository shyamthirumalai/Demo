/**
 * Created by macbookpro on 4/8/16.
 */
public class Fitness_Measures  {

    private int FitnessMeasures_Id;
    private String FitnessMeasuresName;


    public Fitness_Measures()
    {

    }
    public Fitness_Measures(int Id, String FitnessMeasureName){
        this.FitnessMeasures_Id=Id;
        this.FitnessMeasuresName=FitnessMeasureName;
    }

    public int getFitnessMeasures_Id() {
        return FitnessMeasures_Id;
    }

    public void setFitnessMeasures_Id(int fitnessMeasures_Id) {
        FitnessMeasures_Id = fitnessMeasures_Id;
    }

    public String getFitnessMeasuresName() {
        return FitnessMeasuresName;
    }

    public void setFitnessMeasuresName(String fitnessMeasuresName) {
        FitnessMeasuresName = fitnessMeasuresName;
    }




}
