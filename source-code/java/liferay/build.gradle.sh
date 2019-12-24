#!/bin/bash

COLOR_LIGHT_CYAN="\e[36"

printWorkingDirectory(){
	echo ""
	echo "Current Working Directory ===>> $(pwd)"
	echo ""
}

displayOptions(){
	
	echo "+--------------------------------------------+"
	echo "| Available Options                          |"
	echo "+--------------------------------------------+"
	echo ""
	echo "Option 1: build foundation modules"
	echo "Option 2: build services"
	echo "Option 3: build services(piece meal)"
	echo "Option 4: build portlets"
	echo "Option 5: build themes"
	echo "Option 6: build wars"
	echo "Option 7: build hooks"
	echo "option 8: all"
	echo "Option 9: delete 'bin' directory"
	echo "--------------------------------"
	echo "Option 0: Exit"
	echo ""
}

displayServiceBuilderOptions(){
	
	echo "+--------------------------------------------+"
	echo "| Available Service Builders                 |"
	echo "+--------------------------------------------+"
	echo ""
	#echo "Option 1: fiera-bouncy-castle-provider-service"
	echo "Option 2: fiera-milano-service"
	echo "Option 3: fiera-bi-services"
	echo "Option 4: fiera-middleware-services"
	echo "Option 5: fiera-scheduler-service"
	echo "option 8: all"
	echo "--------------------------------"
	echo "Option 0: Exit"
	echo ""
}

deleteBinDirectory(){
	cd modules
	for directory in */ ; do
		echo "deleting bin directory of $directory"
		cd $directory
		rm -rf bin
		cd ..
	done
	cd ..

	cd wars
	for directory in */ ; do
		echo "deleting bin directory of $directory"
		cd $directory
		rm -rf bin
		cd ..
	done
	cd ..

	echo ""
	echo "Done deleting bin directories of modules..."
	echo ""
	printWorkingDirectory
}

buildFoundationModules(){
	cd modules

	echo ""
	echo "Building : fiera lib provider..."
	echo "---------------------------"
	echo ""
	cd fiera-lib-provider
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera clients..."
	echo "---------------------------"
	echo ""
	cd fiera-clients
	../../gradlew clean build deploy
	cd ..

	cd ..
	printWorkingDirectory
}

buildThemes(){
	cd wars

	echo "Building : fiera back-office theme"
	echo "----------------------------------"
	echo ""
	cd fiera-backoffice-theme
	gulp build:clean build
	cp dist/fiera-backoffice-theme.war ../../bundles/osgi/modules
	cd ..

	cd ..
	printWorkingDirectory
}

buildServicesPieceMeal(){
	displayServiceBuilderOptions
	read -p "Which one do you want to build? " sboption
	echo ""
	
	while [ $sboption -ne 0 ]
		do
			case "$sboption" in
			1)
				cd modules
				echo ""
				echo "Building : fiera bouncy castle provider service..."
				echo "---------------------------------------------------"
				echo ""
				cd fiera-bouncy-castle-provider-portlet
				../../gradlew clean buildService build deploy
				cd ../..
			;;
			2)
				cd modules
				echo ""
				echo "Building : fiera milano service..."
				echo "----------------------------------"
				echo ""
				cd fiera-milano-portlet
				../../gradlew clean buildService build deploy
				cd ../..
			;;
			3)
				cd modules
				echo ""
				echo "Building : fiera bi-services service..."
				echo "---------------------------------------"
				echo ""
				cd fiera-bi-services-portlet
				../../gradlew clean buildService build deploy
				cd ../..
			;;
			4)
				cd modules
				echo ""
				echo "Building : fiera middleware service..."
				echo "--------------------------------------"
				echo ""
				cd fiera-middleware-services-portlet
				../../gradlew clean buildService build deploy
				cd ../..
			;;
			5)
				cd modules
				echo ""
				echo "Building : fiera scheduler service..."
				echo "-------------------------------------"
				echo ""
				cd fiera-scheduler-portlet
				../../gradlew clean buildService build deploy
				cd ../..
			;;
			8)
				echo ""
				echo "Building : All the available services..."
				echo "----------------------------------------"
				echo ""
				buildServices
			;;
		esac
		
		displayServiceBuilderOptions
		read -p "Which one do you want to build? " sboption
	done

	printWorkingDirectory
}

buildServices(){
	cd modules

	echo ""
	echo "Building : fiera bouncy castle provider service..."
	echo "---------------------------------------------------"
	echo ""
	cd fiera-bouncy-castle-provider-portlet
	../../gradlew clean buildService build deploy
	cd ..

	echo ""
	echo "Building : fiera milano service..."
	echo "----------------------------------"
	echo ""
	cd fiera-milano-portlet
	../../gradlew clean buildService build deploy
	cd ..

	echo ""
	echo "Building : fiera bi-services service..."
	echo "---------------------------------------"
	echo ""
	cd fiera-bi-services-portlet
	../../gradlew clean buildService build deploy
	cd ..

	echo ""
	echo "Building : fiera middleware service..."
	echo "--------------------------------------"
	echo ""
	cd fiera-middleware-services-portlet
	../../gradlew clean buildService build deploy
	cd ..

	echo ""
	echo "Building : fiera scheduler service..."
	echo "-------------------------------------"
	echo ""
	cd fiera-scheduler-portlet
	../../gradlew clean buildService build deploy
	cd ..

	cd ..
	printWorkingDirectory
}

buildModules(){
	cd modules

	echo ""
	echo "Building : fiera helper..."
	echo "--------------------------"
	echo ""
	cd fiera-helper
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera agenda management portlet..."
	echo "---------------------------------------------"
	echo ""
	cd fiera-agenda-management-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera agent management portlet..."
	echo "--------------------------------------------"
	echo ""
	cd fiera-agent-management-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera airport costs portlet..."
	echo "-----------------------------------------"
	echo ""
	cd fiera-airport-costs-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera anonymize portlet..."
	echo "-------------------------------------"
	echo ""
	cd fiera-anonymize-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera bit match portlet..."
	echo "-------------------------------------"
	echo ""
	cd fiera-bit-match-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera buyer dashboard management portlet..."
	echo "------------------------------------------------------"
	echo ""
	cd fiera-buyer-dashboard-management-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera buyer management portlet..."
	echo "--------------------------------------------"
	echo ""
	cd fiera-buyer-management-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera concierge portlet..."
	echo "-------------------------------------"
	echo ""
	cd fiera-concierge-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera cookie notification portlet..."
	echo "-----------------------------------------------"
	echo ""
	cd fiera-cookie-notification-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera dashboard overview portlet..."
	echo "----------------------------------------------"
	echo ""
	cd fiera-dashboard-overview-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera dashboard portlet..."
	echo "-------------------------------------"
	echo ""
	cd fiera-dashboard-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera emailaddress update portlet..."
	echo "-----------------------------------------------"
	echo ""
	cd fiera-emailaddress-update-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera exhibitor management portlet..."
	echo "------------------------------------------------"
	echo ""
	cd fiera-exhibitor-management-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera exhibitor sso portlet..."
	echo "-----------------------------------------"
	echo ""
	cd fiera-exhibitor-sso-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera frontend widgets portlet..."
	echo "--------------------------------------------"
	echo ""
	cd fiera-front-end-widgets-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera hospitality information portlet..."
	echo "---------------------------------------------------"
	echo ""
	cd fiera-hospitality-information-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera hospitality management portlet..."
	echo "--------------------------------------------------"
	echo ""
	cd fiera-hospitality-management-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera iam portlet..."
	echo "-------------------------------"
	echo ""
	cd fiera-iam-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera industry sector management portlet..."
	echo "------------------------------------------------------"
	echo ""
	cd fiera-industry-sector-management-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera manifest administration portlet..."
	echo "---------------------------------------------------"
	echo ""
	cd fiera-manifest-administration-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera messaging portlet..."
	echo "-------------------------------------"
	echo ""
	cd fiera-messaging-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera milano language portlet..."
	echo "-------------------------------------------"
	echo ""
	cd fiera-milano-language-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera myarea top portlet..."
	echo "--------------------------------------"
	echo ""
	cd fiera-myarea-top-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera questionaire management portlet..."
	echo "---------------------------------------------------"
	echo ""
	cd fiera-questionaire-management-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera secretary management portlet..."
	echo "------------------------------------------------"
	echo ""
	cd fiera-secretary-management-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera sites management portlet..."
	echo "--------------------------------------------"
	echo ""
	cd fiera-sites-management-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera system lists portlet..."
	echo "----------------------------------------"
	echo ""
	cd fiera-system-lists-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera ticket office management portlet..."
	echo "----------------------------------------------------"
	echo ""
	cd fiera-ticket-office-management-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera user management portlet..."
	echo "-------------------------------------------"
	echo ""
	cd fiera-user-management-portlet
	../../gradlew clean build deploy
	cd ..

	echo ""
	echo "Building : fiera REST services portlet..."
	echo "-----------------------------------------"
	echo ""
	cd fiera-rest-services-portlet
	../../gradlew clean build deploy
	cd ..

	cd ..
	printWorkingDirectory
}

buildWars(){

	cd wars

	echo ""
	echo "Building : fiera REST full web-services portlet..."
	echo "--------------------------------------------------"
	echo ""
	cd fiera-REST-full-web-services-portlet
	../../gradlew clean build deploy
	cd ..

	cd ..
	printWorkingDirectory
}

buildHooks(){
	echo "${COLOR_LIGHT_CYAN}Building hooks..."
}

echo ""
echo "Welcome to the Fiera Match Making builder tool...."
echo ""

displayOptions
read -p "Enter your option ? " option
echo ""
while [ $option -ne 0 ]
	do
		case "$option" in
			1) buildFoundationModules
			;;
			2) buildServices
			;;
			3) buildServicesPieceMeal
			;;
			4) buildModules
			;;
			5) buildThemes
			;;
			6) echo "No building of .war files..."
				echo ""
			;;
			7) buildHooks
			;;
			8) 
				buildFoundationModules
				buildServices
				buildModules
				#buildWars
				buildHooks
				buildThemes
			;;
			9)  echo "Need to improvise this functionality... please stay with patience. Thanks."
				echo ""
			;;
		esac
		displayOptions
		read -p "Enter your option ? " option
done
