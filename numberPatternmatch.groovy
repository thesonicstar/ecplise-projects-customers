import java.util.regex.Pattern
import java.util.regex.Matcher

def trigAlert = "Request timed out | Could not open connection to the host, on port 3303: Connect failed";

//Regex regex = new Regex("\d+");

port = trigAlert.find(/\d+/);

println port