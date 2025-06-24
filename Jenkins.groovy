pipeline{
	agent { label "Linux" }
	options {
		skipDefaultCheckout(true)
	}
	stages{
		stage("Checkout"){
			steps{
				cleanWs()
				dir("Lang"){
					git url: "https://github.com/NumbatLogic/Lang",
						branch: "main",
						credentialsId: 'c532651f-f9a2-48a8-8a37-8df46a9c5ee2'
				}
				dir("LangShared"){
					git url: "https://github.com/NumbatLogic/LangShared",
						branch: "main",
						credentialsId: 'c532651f-f9a2-48a8-8a37-8df46a9c5ee2'
				}
				dir("ProjectGen"){
					git url: "https://github.com/NumbatLogic/ProjectGen",
						branch: "main",
						credentialsId: 'c532651f-f9a2-48a8-8a37-8df46a9c5ee2'
				}
				dir("CodeCrab"){
					git url: "https://github.com/NumbatLogic/CodeCrab",
						branch: "main",
						credentialsId: 'c532651f-f9a2-48a8-8a37-8df46a9c5ee2'
				}
				dir("LangSharedTest"){
					git url: "https://github.com/NumbatLogic/LangSharedTest",
						branch: "main",
						credentialsId: 'c532651f-f9a2-48a8-8a37-8df46a9c5ee2'
				}
			}
		}

		stage("Build"){
			steps{
				sh "cd Lang && RebuildCPP.sh && cd ../LangSharedTest && ./Rebuild.sh && ./TestCPP.sh && ./TestCS.sh"
			}
		}

		stage("Log Parse"){
			steps{
				logParser ([
					projectRulePath: 'Lang/LogParsingRules',
					parsingRulesPath: '',
					showGraphs: true, 
					unstableOnWarning: true, 
					useProjectRule: true
				])
			}
		}
	}
}