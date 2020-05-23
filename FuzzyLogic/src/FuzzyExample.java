import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

public class FuzzyExample {

    public static void main(String[] args) throws Exception {
        try {
            String fileName = args[0];
            int waterTemperature = Integer.parseInt(args[1]);
            int waterPetrification = Integer.parseInt(args[2]);
            int dayTime = Integer.parseInt(args[3]);
            int sugarLevel = Integer.parseInt(args[4]);
            FIS fis = FIS.load(fileName,false);

//wyswietl wykresy funkcji fuzyfikacji i defuzyfikacji
            FuzzyRuleSet fuzzyRuleSet = fis.getFuzzyRuleSet();
            fuzzyRuleSet.chart();

//zadaj wartosci wejsciowe
            fuzzyRuleSet.setVariable("water_temperature", waterTemperature);
            fuzzyRuleSet.setVariable("water_petrification", waterPetrification);
            fuzzyRuleSet.setVariable("day_time", dayTime);
            fuzzyRuleSet.setVariable("sugar_level", sugarLevel);

//logika sterownika
            fuzzyRuleSet.evaluate();

//graficzna prezentacja wyjscia
            fuzzyRuleSet.getVariable("preparing_time").chartDefuzzifier(true);

//System.out.println(fuzzyRuleSet);

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Niepoprawna liczba parametrow. Przyklad: java FuzzyExample string<plik_fcl> int<poziom natezenia> int<pora dnia>");
        } catch (NumberFormatException ex) {
            System.out.println("Niepoprawny parametr. Przyklad: java FuzzyExample string<plik_fcl> int<temperatura wody>" +
                    " int<topień skamienienia wody> int<pora dnia> int<poziom cukru>");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}