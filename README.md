	 * 1.在Android Studio中编译运行或者运行task lint，如果在cmd运行，则在工程目录运行gradlew :lint
	 * 2.运行结束后会在工程目录生成\build\outputs\lint-results.xml文件
	 * 3.修改本程序中的路径为{ProjectHome}\build\outputs\lint-results.xml,然后运行即可。
	 * 4.由于资源引用问题，请重复运行前面三步骤直到资源全部删除为止。
	 * 5.lint有可能会错误，造成误删除，所以删除完成后可以检测工程是否完整，如果不完整则Reverse Resource
