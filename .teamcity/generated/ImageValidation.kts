// NOTE: THIS IS AN AUTO-GENERATED FILE. IT HAD BEEN CREATED USING TEAMCITY.DOCKER PROJECT. ...
// ... IF NEEDED, PLEASE, EDIT DSL GENERATOR RATHER THAN THE FILES DIRECTLY. ...
// ... FOR MORE DETAILS, PLEASE, REFER TO DOCUMENTATION WITHIN THE REPOSITORY.
package generated

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.dockerSupport
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.freeDiskSpace
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.swabra
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.dockerCommand
import common.TeamCityDockerImagesRepo.TeamCityDockerImagesRepo
import jetbrains.buildServer.configs.kotlin.v2019_2.failureConditions.BuildFailureOnText
import jetbrains.buildServer.configs.kotlin.v2019_2.failureConditions.failOnText
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.kotlinFile
import jetbrains.buildServer.configs.kotlin.v2019_2.Trigger
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.finishBuildTrigger
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

object image_validation: BuildType(
    {
        name = "Validation (post-push) of Docker images"
        buildNumberPattern="test-%build.counter%"



        steps {
            kotlinFile {
                name = "Image Verification - %docker.deployRepository%teamcity-server:2022.10-linux"
                path = "tool/automation/ImageValidation.kts"
                arguments = "%docker.deployRepository%teamcity-server:2022.10-linux"
            }

            kotlinFile {
                name = "Image Verification - %docker.deployRepository%teamcity-agent:2022.10-linux-arm64-sudo"
                path = "tool/automation/ImageValidation.kts"
                arguments = "%docker.deployRepository%teamcity-agent:2022.10-linux-arm64-sudo"
            }

            kotlinFile {
                name = "Image Verification - %docker.deployRepository%teamcity-agent:2022.10-linux-arm64"
                path = "tool/automation/ImageValidation.kts"
                arguments = "%docker.deployRepository%teamcity-agent:2022.10-linux-arm64"
            }

            kotlinFile {
                name = "Image Verification - %docker.deployRepository%teamcity-agent:2022.10-linux"
                path = "tool/automation/ImageValidation.kts"
                arguments = "%docker.deployRepository%teamcity-agent:2022.10-linux"
            }

            kotlinFile {
                name = "Image Verification - %docker.deployRepository%teamcity-agent:2022.10-linux-sudo"
                path = "tool/automation/ImageValidation.kts"
                arguments = "%docker.deployRepository%teamcity-agent:2022.10-linux-sudo"
            }

            kotlinFile {
                name = "Image Verification - %docker.deployRepository%teamcity-minimal-agent:2022.10-linux"
                path = "tool/automation/ImageValidation.kts"
                arguments = "%docker.deployRepository%teamcity-minimal-agent:2022.10-linux"
            }

            kotlinFile {
                name = "Image Verification - %docker.deployRepository%teamcity-server:2022.10-nanoserver-1809"
                path = "tool/automation/ImageValidation.kts"
                arguments = "%docker.deployRepository%teamcity-server:2022.10-nanoserver-1809"
            }

            kotlinFile {
                name = "Image Verification - %docker.deployRepository%teamcity-agent:2022.10-windowsservercore-1809"
                path = "tool/automation/ImageValidation.kts"
                arguments = "%docker.deployRepository%teamcity-agent:2022.10-windowsservercore-1809"
            }

            kotlinFile {
                name = "Image Verification - %docker.deployRepository%teamcity-agent:2022.10-nanoserver-1809"
                path = "tool/automation/ImageValidation.kts"
                arguments = "%docker.deployRepository%teamcity-agent:2022.10-nanoserver-1809"
            }

            kotlinFile {
                name = "Image Verification - %docker.deployRepository%teamcity-minimal-agent:2022.10-nanoserver-1809"
                path = "tool/automation/ImageValidation.kts"
                arguments = "%docker.deployRepository%teamcity-minimal-agent:2022.10-nanoserver-1809"
            }

            kotlinFile {
                name = "Image Verification - %docker.deployRepository%teamcity-server:2022.10-nanoserver-2004"
                path = "tool/automation/ImageValidation.kts"
                arguments = "%docker.deployRepository%teamcity-server:2022.10-nanoserver-2004"
            }

            kotlinFile {
                name = "Image Verification - %docker.deployRepository%teamcity-agent:2022.10-windowsservercore-2004"
                path = "tool/automation/ImageValidation.kts"
                arguments = "%docker.deployRepository%teamcity-agent:2022.10-windowsservercore-2004"
            }

            kotlinFile {
                name = "Image Verification - %docker.deployRepository%teamcity-agent:2022.10-nanoserver-2004"
                path = "tool/automation/ImageValidation.kts"
                arguments = "%docker.deployRepository%teamcity-agent:2022.10-nanoserver-2004"
            }

            kotlinFile {
                name = "Image Verification - %docker.deployRepository%teamcity-minimal-agent:2022.10-nanoserver-2004"
                path = "tool/automation/ImageValidation.kts"
                arguments = "%docker.deployRepository%teamcity-minimal-agent:2022.10-nanoserver-2004"
            }

        }
        failureConditions {
            failOnText {
                conditionType = BuildFailureOnText.ConditionType.REGEXP
                pattern = "*DockerImageValidationException.*"
                // allows the steps to continue running even in case of one problem
                reportOnlyFirstMatch = false
            }
        }
        triggers {
            finishBuildTrigger {
                buildType = "${PublishHubVersion.publish_hub_version.id}"
            }
        }
	dependencies {
//		 dependency(AbsoluteId("TC_Trunk_DockerImages_push_hub_windows")) {
//			 snapshot { onDependencyFailure = FailureAction.ADD_PROBLEM }
//		 }
//		 dependency(AbsoluteId("TC_Trunk_DockerImages_push_hub_linux")) {
//			 snapshot { onDependencyFailure = FailureAction.ADD_PROBLEM }
//		 }

        // -- build number dependency
        dependency(AbsoluteId("TC_Trunk_BuildDistDocker")) {
            reuseBuilds = ReuseBuilds.ANY
            onDependencyFailure = FailureAction.IGNORE
        }
	}
    })
