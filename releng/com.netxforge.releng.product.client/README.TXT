Releng Product Template
=======================

This is a template for building NetXStudio products. 
It includes: 

1. The Query (netxstudio.cquery) for the resolution process.
The query resolves from a previously generated p2 site, which includes our materialized dependencies, 
including ther 

2. a customized .cspex which defines several actions: 

2.1 create.product(.zip)

Creates a product invoking the p2 director, through an ANT build file. 
The ANT build file is part of Action definitions to build various kinds 
of products. 

The the .zip Action uses a standard pde task to .zip, but requries the target create.product first. 

p2 director information: 

http://help.eclipse.org/galileo/index.jsp?topic=/org.eclipse.platform.doc.isv/guide/p2_director.html


CSPEX
=====

General Properties

1. profile => value is netxStudioClientProfile [TODO, not sure what this means???]
2. iu => The 'Installable Unit' which is our product to build. 
3. repo => a URL for the repository. (Note, we prefer this than the site.p2 property in prerequisites). 

ACTION:=> Replace the installable unit with the id of the product to build! 

Creates a product with the following inputs for an ANT actor: 
(See: buckybook.pdf => Chapter 
 
Actor Properties.  

1. buildFile => a path to the ant build file to perform the build. 
2  targets => The ant target to call, which is "create.product" in our case. 

Products (The output produced by the Action)

1. destination => The base directory where the output is produced, in our case the default buckminster.output
2. path => The name of the directory of the result. 

Prerequisites: 

1. repository => The repository for the director to use. which points to the site.p2 Attibute (Actor). 


ANT TASK
========

The ant task uses the properties to build the product. 
(See documentation in the ANT task). 

P2 Director properties
======================

Arguments Description

    -application org.eclipse.equinox.p2.director: the application ID.
    -metadataRepository: a comma separated list of metadata repository URLs where the software to be installed can be found.
    -artifactRepository: a comma separated list of artifact repository URLs where the software artifacts can be found.
    -repository: a comma separated list of repository URL where each entry denotes colocated meta-data and artifact repositories.
    -installIU: a comma separated list of IUs to install. Each entry in the list is in the form <id> [ '/' <version> ]. If you are looking to install a feature, the identifier of the feature has to be suffixed with ".feature.group".
    -uninstallIU: a comma separated list of IUs to uninstall. Each entry in the list is in the form <id> [ '/' <version> ].
    -revert: Revert the installation to a previous state. The previous state can either be a tag (see -tag / -listtags) or a previous profile state [ the number representing the previous state of the profile as found in p2/org.eclipse.equinox.p2.engine/<profileId>/ ].
    -purgeHistory: Remove the history of the profile registry.
    -destination: the path of a folder in which the targeted product is located.
    -list: lists all IU's found in the given repositories in a property like format. The optional arguments can be an comma separated list of entries where each entry is in the form <id> [ '/' <version> ], or a p2 QL query prefixed with Q:, or Q:group as shortcut for groups.
    -listTags: list all the tags found for the given profile.
    -listInstalledRoots: list all the roots IUs found in the given profile. Each entry is the list in the form id / version
    -profile: the profile id containing the description of the targeted product. This ID is is defined by the eclipse.p2.profile property contained in the config.ini of the targeted product. For the Eclipse SDK the ID is "SDKProfile"
    -profileProperties: a comma separated list of <key>=<value> pair. The property org.eclipse.update.install.features=true will cause the update manager features to be installed.
    -bundlepool: the location of where the plug-ins and features will be stored. This value is only taken into account when a new profile is created. For an application where all the bundles are located into the plugins/ folder of the destination, set it to <destination>.
    -p2.os: the OS to use when the profile is created. This will be used to filter which OS specific installable units need to be installed.
    -p2.ws: the windowing system to use when the profile is created. This will be used to filter which WS specific installable units need to be installed.
    -p2.arch: the architecture to use when the profile is created. This will be used to filter which architecture specific installable units need to be installed.
    -roaming: indicates that the product resulting from the installation can be moved. This property only makes sense when the destination and bundle pool are in the same location. This value is only taken into account when the profile is created.
    -shared: use a shared location for the install. The path defaults to ${user.home}/.p2.
    -tag: a label. This allows to tag the profile state resulting from the operation being executed.
    -verifyOnly: only verify that the actions can be performed. Don't actually install or remove anything.


ANT TROUBLESHOOTING
===================

When invoking the P2 director from an ANT task, it's invoked from here.  

/var/lib/jenkins/tools/Buckminster/4.2/buckminster/configuration

The director is launched with as: 

Framework arguments:  -application org.eclipse.equinox.p2.director -repository http://p2.netxforge.com/own.p2/ -destination /var/lib/jenkins/workspace/netxstudio.product/buckminster.out
put/com.netxforge.releng.product.client_1.0.0-eclipse.feature/netxstudio.bare.win32.win32.x86 -profile netxStudioClientProfile -profileProperties org.eclipse.update.install.features=tru
e -installIU com.netxforge.netxstudio.bare -p2.os win32 -p2.ws win32 -p2.arch x86

Command-line arguments:  -application org.eclipse.equinox.p2.director -repository http://p2.netxforge.com/own.p2/ -destination /var/lib/jenkins/workspace/netxstudio.product/buckminster.
output/com.netxforge.releng.product.client_1.0.0-eclipse.feature/netxstudio.bare.win32.win32.x86 -profile netxStudioClientProfile -profileProperties org.eclipse.update.install.features=
true -installIU com.netxforge.netxstudio.bare -p2.os win32 -p2.ws win32 -p2.arch x86 -consoleLog







