jenkins.model.Jenkins.getInstance().getUpdateCenter().getSites().each { site ->
    site.updateDirectlyNow(hudson.model.DownloadService.signatureCheck)
}

hudson.model.DownloadService.Downloadable.all().each { downloadable ->
    downloadable.updateNow();
}

def plugins = jenkins.model.Jenkins.instance.pluginManager.activePlugins.findAll {
    it -> it.hasUpdate()
}.collect {
    it -> it.getShortName()
}

jenkins.model.Jenkins.instance.pluginManager.install(plugins, false).each { f ->
    f.get()
}

if(plugins.size() != 0) {
    println "Plugins to upgrade: ${plugins}"
    jenkins.model.Jenkins.instance.safeRestart()
} else{
    println "All plugins updated!"
}