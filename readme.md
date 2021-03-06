[![GitHub release (latest SemVer)](https://img.shields.io/github/v/release/sciator/hana?&style=for-the-badge)](https://github.com/sciator/hana/releases)
[![GitHub Workflow Status build](https://img.shields.io/github/workflow/status/sciator/hana/Release?&style=for-the-badge)](https://github.com/sciator/hana/releases)
[![GitHub Workflow Status test](https://img.shields.io/github/workflow/status/sciator/hana/Tests?label=tests&style=for-the-badge)](https://github.com/sciator/hana/actions?query=workflow%3ATests)
[![GitHub last commit](https://img.shields.io/github/last-commit/sciator/hana?&style=for-the-badge)](https://github.com/sciator/hana/commits/master)
[![GitHub commit activity](https://img.shields.io/github/commit-activity/m/sciator/hana?&style=for-the-badge)](https://github.com/sciator/hana/graphs/commit-activity)
[![Lines of code](https://img.shields.io/tokei/lines/github/sciator/hana?&style=for-the-badge)](https://github.com/sciator/hana/pulse)
[![GitHub issues](https://img.shields.io/github/issues/sciator/hana?&style=for-the-badge)](https://github.com/sciator/hana/issues)
[![GitHub](https://img.shields.io/github/license/sciator/hana?&style=for-the-badge)](https://github.com/sciator/hana/blob/master/license.md)
[![GitHub top language](https://img.shields.io/github/languages/top/sciator/hana?&style=for-the-badge)](https://github.com/sciator/hana)

[![Spring](https://img.shields.io/badge/spring%20-%236DB33F.svg?&style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/)
[![Kotlin](https://img.shields.io/badge/kotlin-%230095D5.svg?&style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Typescript](https://img.shields.io/badge/typescript%20-%23007ACC.svg?&style=for-the-badge&logo=typescript&logoColor=white)](https://www.typescriptlang.org/)

[![MS SQL](https://img.shields.io/badge/-MS%20SQL-%23CC2927.svg?&style=for-the-badge&logo=Microsoft-SQL-Server&logoColor=white)](https://www.microsoft.com/cs-cz/sql-server/)
[![react](https://img.shields.io/badge/react%20-%2320232a.svg?&style=for-the-badge&logo=react&logoColor=%2361DAFB)](https://reactjs.org/)
[![HTML5](https://img.shields.io/badge/html5%20-%23E34F26.svg?&style=for-the-badge&logo=html5&logoColor=white)](https://www.w3schools.com/html/)
[![sass](https://img.shields.io/badge/SASS%20-hotpink.svg?&style=for-the-badge&logo=SASS&logoColor=white)](https://sass-lang.com/)

[![git](https://img.shields.io/badge/git%20-%23F05033.svg?&style=for-the-badge&logo=git&logoColor=white)](https://git-scm.com/)
[![github](https://img.shields.io/badge/github%20-%23121011.svg?&style=for-the-badge&logo=github&logoColor=white)](https://github.com/)
[![github actions](https://img.shields.io/badge/GH%20Actions-%23161616.svg?&style=for-the-badge&logo=github&logoColor=white)](https://github.com/actions)
[![webpack](https://img.shields.io/badge/webpack%20-%238DD6F9.svg?&style=for-the-badge&logo=webpack&logoColor=black)](https://webpack.js.org/)
[![Maven](https://img.shields.io/badge/-Maven-C71A36?&style=for-the-badge&logoColor=white&logo=apache-maven)](https://maven.apache.org/)
[![semantic-release](https://img.shields.io/badge/%20%20%F0%9F%93%A6%F0%9F%9A%80-semantic--release-e10079.svg?&style=for-the-badge&logoColor=white)](https://github.com/semantic-release/semantic-release)


## Building and dev

All commited code should follow the [contributing](./contributing.md)

### prerequisites
   - [node](https://nodejs.org/) installed
   - [yarn](https://yarnpkg.com/) installed
   - [java](https://java.com/) installed
   - [maven](https://maven.apache.org/) installed _([optional *](#maven-wrapper))_


### distribution
   - ```yarn dist```

### dev
call ```yarn install``` (if not called already)
   - ALL
      - ```mvn install spring-boot:run``` (compile in parallel by adding the ```-T 1C``` to command)
   - Server only
      - ```mvn install -pl !ui spring-boot:run``` builds and deploys Spring server on ````localhost:8080````
   - UI only
      - ```yarn dev:ui```/```yarn dev```

### maven-wrapper
If you do not have maven installed locally (and you do not want to install it), you can use project's maven-wrapper.
At first, run the ```./mvnw.cmd clean install``` or ```./mvnw clean install``` (on Unix systems) command.
On Unix systems, it might be necessary to allow execute permissions using ```chmod +x ./mvnw```.
Then simply replace the ```mvn``` commands with ```./mvnw.cmd``` or ```./mvnw```.
