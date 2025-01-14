import com.android.build.api.dsl.ApplicationExtension
import com.example.convention.ExtensionTypeEnum
import com.example.convention.configureBuildTypes
import com.example.convention.configureKotlinAndroid
import com.example.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            // here is scope of kotlin inside target so don't need to write target.a or target.b etc instead write a or b
            pluginManager.run {
                apply(libs.findPlugin("android.application").get().get().pluginId)
                apply(libs.findPlugin("kotlin.android").get().get().pluginId)
            }
            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    applicationId = libs.findVersion("projectApplicationId").get().toString()
                    versionCode = libs.findVersion("projectVersionCode").get().toString().toInt()
                    versionName = libs.findVersion("projectVersionName").get().toString()
                    targetSdk = libs.findVersion("projectTargetSdkVersion").get().toString().toInt()
                }

                configureKotlinAndroid(this)
                configureBuildTypes(this, ExtensionTypeEnum.APPLICATION)
            }
        }
    }
}