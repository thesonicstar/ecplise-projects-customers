def threshold = "0"
int procount = threshold.toInteger();

if(threshold="0") {
    status = "BAD"
    println "BAD"
    println "\nProcess Count: " + procount
}
else {
    if (procount) {
        if(procount>=80){
            println "GOOD"
            status = "GOOD"
            println "\nProcess Count: " + procount
        }
        else {
            status = "BAD"
            println "BAD"
            println "\nProcess Count: " + procount
        }
    } 
    
    else {
        println "No INPUT found"
        severity = "WARNING"
        status = "BAD"
        println procount
    }
}    