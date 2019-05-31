// When sending the params ot the function of the class, then in 12 hour format your should place zero to the figures below 10, that is 
//  the requirment of the application server data

public class TimeRefine {
    // member variables
    private String mTimeStandard;

    // default constructor
    public TimeRefine(String timeStandard){
        mTimeStandard = timeStandard; // init the time standard
    }

    // function to filter the data from the timestandard
    public void SetTimeStandard(String targetSubString){
        int tHour = 0;
        if (mTimeStandard.charAt(0) == '0'){
            mTimeStandard = mTimeStandard.replace(targetSubString, "AM");
        }else {
            // init the tHour time
            tHour = Character.getNumericValue(mTimeStandard.charAt(0)) * 10;
            int resultValue = tHour + Character.getNumericValue(mTimeStandard.charAt(1));

            if (resultValue <= 12){
                // tHour time is smaller than or equal to 12, then
                mTimeStandard = mTimeStandard.replace(targetSubString, "AM");
            }else{
                // if the value is above 12, then
                /*1) Apply t-12 formula to the time
                * 2) Change the significance of the time to 12 Hour format for user friendly code*/
                if((resultValue-12) <= 9){
                    mTimeStandard = mTimeStandard.replace(String.valueOf(resultValue), "0"+String.valueOf(resultValue-12));
                    mTimeStandard = mTimeStandard.replace(targetSubString, "PM");
                }else {
                    mTimeStandard = mTimeStandard.replace(String.valueOf(resultValue), String.valueOf(resultValue-12));
                    mTimeStandard = mTimeStandard.replace(targetSubString, "PM");
                }
            }
        }
    }

    public String GetTimeStandard(){
        return mTimeStandard;
    }
}
