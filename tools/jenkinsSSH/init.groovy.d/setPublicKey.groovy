import org.jenkinsci.main.modules.cli.auth.ssh.UserPropertyImpl
import hudson.model.User

user = User.get('admin')
pubKey = new UserPropertyImpl(getFileContent('/usr/share/jenkins/key/id_jenkins_ssh'))

user.addProperty(pubKey)
user.save()