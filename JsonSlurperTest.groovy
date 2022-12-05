import groovy.json.*
import groovy.json.JsonSlurper.*

def content = '{"type":"syslog","@timestamp":"2021-02-25T17:40:33.713Z","message":"<140>Feb 26 00:40:33 scc-rss-01 root[20657]: Number of SAP process = 2 on scc-rss-01.mea.or.th which is too high","@version":"1","host":"10.70.100.180"}';

//def jsonSlurper = JsonSlurper()
//def object = jsonSlurper.parseText('{ "name": "John Doe" } /* some comment */')
/*def object = jsonSlurper.parseText(content);

println object*/


def slurper = new JsonSlurper()
def result = slurper.parseText('{"person":{"name":"Guillaume","age":33,"pets":["dog","cat"]}}')

assert result.person.name == "Guillaume"
assert result.person.age == 33
assert result.person.pets.size() == 2
assert result.person.pets[0] == "dog"
assert result.person.pets[1] == "cat"