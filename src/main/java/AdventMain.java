import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AdventMain {

    public static void main(final String[] args) throws IOException {
        AdventMain adventMain = new AdventMain();
        adventMain.run();
    }

    public final void run() throws IOException {
        System.out.println("Input: \n");

        List<String> num = new ArrayList<>();

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = stdin.readLine()) != null && line.length()!= 0) {
            num.add(line);
        }

        int[] result = new int[num.size()];

        for(int i=0; i<result.length; i++) {
            result[i] = Integer.parseInt(num.get(i));
        }

        evaluateVariation(result);
    }

    private void evaluateVariation(int[] result) {
        int prevVal = 0;
        List<String> finalResp = new ArrayList<>();
        for(int r:result) {
            finalResp.add(processVariation(prevVal, r));
            prevVal=r;
        }
        long countVal = finalResp.stream().filter(it->it.equalsIgnoreCase("INCREASED")).count();
        System.out.println("TOTAL INCREASES: "+countVal);
    }

    private String processVariation(int prevVal, int currentVal){
        if(prevVal==0){
            return "NA";
        }
        if(prevVal<currentVal) {
            return "INCREASED";
        }
        if(prevVal>currentVal) {
            return "DECREASED";
        }
        return "NA";
    }
}
