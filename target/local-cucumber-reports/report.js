$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/resources/Features/Test.feature");
formatter.feature({
  "line": 1,
  "name": "",
  "description": "",
  "id": "",
  "keyword": "Feature"
});
formatter.before({
  "duration": 344390201,
  "status": "passed"
});
formatter.scenario({
  "line": 2,
  "name": "",
  "description": "",
  "id": ";",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "I login to DEMOAUT web application",
  "keyword": "Given "
});
formatter.match({
  "location": "Login.iLoginToDEMOAUTWebApplication()"
});
formatter.result({
  "duration": 4489924900,
  "status": "passed"
});
});