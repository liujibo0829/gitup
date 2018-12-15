function addDailyReport() {
	var gnl = confirm("确认提交日报?");
	if (gnl == true) {
		var text = $("#dailyReport").val();
		if (text == "" || text == undefined || text == null
				|| (text.length > 0 && text.trim().length == 0)) {
			alert("请填写日报！！！");
			return false;
		}
		return true;
	} else {
		return false;
	}
}

function addDept() {
	var gnl = confirm("确认添加部门?");
	if (gnl == true) {
		var deptName = $("#deptName").val();
		var deptLocal = $("#deptLocal").val();
		if (deptName == "" || deptName == undefined || deptName == null
				|| (deptName.length > 0 && deptName.trim().length == 0)) {
			document.getElementById("msgdeptName").innerHTML = "<font id='msgdeptname' color='red'>部门名称不能为空</font>";
			return false;
		}
		if (deptLocal == "" || deptLocal == undefined || deptLocal == null
				|| (deptLocal.length > 0 && deptLocal.trim().length == 0)) {
			document.getElementById("msgdeptLocal").innerHTML = "<font  id='msgdeptlocal' color='red'>部门地点不能为空</font>";
			return false;
		}
		return true;
	} else {
		return false;
	}
}
function upDept() {
	var gnl = confirm("确认修改部门?");
	if (gnl == true) {
		var deptName = $("#deptName").val();
		var deptLocal = $("#deptLocal").val();
		if (deptName == "" || deptName == undefined || deptName == null
				|| (deptName.length > 0 && deptName.trim().length == 0)) {
			document.getElementById("msgdeptName").innerHTML = "<font id='msgdeptname' color='red'>部门名称不能为空</font>";
			return false;
		}
		if (deptLocal == "" || deptLocal == undefined || deptLocal == null
				|| (deptLocal.length > 0 && deptLocal.trim().length == 0)) {
			document.getElementById("msgdeptLocal").innerHTML = "<font  id='msgdeptlocal' color='red'>部门地点不能为空</font>";
			return false;
		}
		return true;
	} else {
		return false;
	}
}

function disDeptName() {
	if ($("#msgdeptname").length > 0) {
		$("#msgdeptname").remove();
	}
}
function disDeptLocal() {
	if ($("#msgdeptlocal").length > 0) {
		$("#msgdeptlocal").remove();
	}
}

function Role() {
	var gnl = confirm("确认添加角色?");
	if (gnl == true) {
		var roleName = $("#roleName").val();
		if (roleName == "" || roleName == undefined || roleName == null
				|| (roleName.length > 0 && roleName.trim().length == 0)) {
			document.getElementById("msgroleName").innerHTML = "<font  id='msgrole' color='red'>角色名称不能为空</font>";
			return false;
		}
		return true;
	} else {
		return false;
	}
}
function disRoleName() {
	if ($("#msgrole").length > 0) {
		$("#msgrole").remove();
	}
}
function addUser() {
	var gnl = confirm("确认添加用户?");
	if (gnl == true) {
		var userName = $("#userName").val();
		var userAccount = $("#userAccount").val();
		var userPassword = $("#userPassword").val();
		var userRole = $("#roleId").val();
		var userdept = $("#deptId").val();
		if (userName == "" || userName == undefined || userName == null
				|| (userName.length > 0 && userName.trim().length == 0)) {
			document.getElementById("msguserName").innerHTML = "<font id='msgusername' color='red'>用户名称不能为空</font>";
			return false;
		}

		if (userAccount == "" || userAccount == undefined
				|| userAccount == null
				|| (userAccount.length > 0 && userAccount.trim().length == 0)) {
			document.getElementById("msguserAccount").innerHTML = "<font  id='msguseraccount' color='red'>用户账号地点不能为空</font>";
			return false;
		}
		if (userPassword == "" || userPassword == undefined
				|| userPassword == null
				|| (userPassword.length > 0 && userPassword.trim().length == 0)) {
			document.getElementById("msguserPassword").innerHTML = "<font id='msguserpassword' color='red'>用户密码不能为空</font>";
			return false;
		}
		if (userRole == "" || userRole == undefined || userRole == null
				|| (userRole.length > 0 && userRole.trim().length == 0)) {
			document.getElementById("msgroleId").innerHTML = "<font  id='msgroleid' color='red'>角色不能为空</font>";
			return false;
		}
		if (userdept == "" || userdept == undefined || userdept == null
				|| (userdept.length > 0 && userdept.trim().length == 0)) {
			document.getElementById("msgdeptId").innerHTML = "<font id='msgdeptid' color='red'>部门不能为空</font>";
			return false;
		}
		return true;
	} else {
		return false;
	}
}

function upUser() {
	var gnl = confirm("确认修改用户?");
	if (gnl == true) {
		var userName = $("#userName").val();
		var userAccount = $("#userAccount").val();
		var userPassword = $("#userPassword").val();
		var userRole = $("#roleId").val();
		var userdept = $("#deptId").val();
		if (userName == "" || userName == undefined || userName == null
				|| (userName.length > 0 && userName.trim().length == 0)) {
			document.getElementById("msguserName").innerHTML = "<font id='msgusername' color='red'>用户名称不能为空</font>";
			return false;
		}

		if (userAccount == "" || userAccount == undefined
				|| userAccount == null
				|| (userAccount.length > 0 && userAccount.trim().length == 0)) {
			document.getElementById("msguserAccount").innerHTML = "<font  id='msguseraccount' color='red'>用户账号地点不能为空</font>";
			return false;
		}
		if (userPassword == "" || userPassword == undefined
				|| userPassword == null
				|| (userPassword.length > 0 && userPassword.trim().length == 0)) {
			document.getElementById("msguserPassword").innerHTML = "<font id='msguserpassword' color='red'>用户密码不能为空</font>";
			return false;
		}
		if (userRole == "" || userRole == undefined || userRole == null
				|| (userRole.length > 0 && userRole.trim().length == 0)) {
			document.getElementById("msgroleId").innerHTML = "<font  id='msgroleid' color='red'>角色不能为空</font>";
			return false;
		}
		if (userdept == "" || userdept == undefined || userdept == null
				|| (userdept.length > 0 && userdept.trim().length == 0)) {
			document.getElementById("msgdeptId").innerHTML = "<font id='msgdeptid' color='red'>部门不能为空</font>";
			return false;
		}
		return true;
	} else {
		return false;
	}
}
function disuserName() {
	if ($("#msgusername").length > 0) {
		$("#msgusername").remove();
	}
}
function disuserAccount() {
	if ($("#msguseraccount").length > 0) {
		$("#msguseraccount").remove();
	}
}
function disuserPassword() {
	if ($("#msguserpassword").length > 0) {
		$("#msguserpassword").remove();
	}
}
function disroleId() {
	if ($("#msgroleid").length > 0) {
		$("#msgroleid").remove();
	}
}
function disdeptId() {
	if ($("#msgdeptid").length > 0) {
		$("#msgdeptid").remove();
	}
}
function addMenu() {
	var gnl = confirm("确认添加子菜单?");
	if (gnl == true) {
		var menuName = $("#menuName").val();
		var menuMenuId = $("#menuMenuId").val();
		if (menuName == "" || menuName == undefined || menuName == null
				|| (menuName.length > 0 && menuName.trim().length == 0)) {
			document.getElementById("msgmenuName").innerHTML = "<font id='msgmenuname' color='red'>部门名称不能为空</font>";
			return false;
		}
		if (menuMenuId == "" || menuMenuId == undefined || menuMenuId == null
				|| (menuMenuId.length > 0 && menuMenuId.trim().length == 0)) {
			document.getElementById("msgmenuMenuid").innerHTML = "<font  id='msgmenumenuid' color='red'>部门地点不能为空</font>";
			return false;
		}
		return true;
	} else {
		return false;
	}
}
function upMenu() {
	var gnl = confirm("确认修改菜单?");
	if (gnl == true) {
		var menuName = $("#menuName").val();
		var menuMenuId = $("#menuMenuId").val();
		if (menuName == "" || menuName == undefined || menuName == null
				|| (menuName.length > 0 && menuName.trim().length == 0)) {
			document.getElementById("msgmenuName").innerHTML = "<font id='msgmenuname' color='red'>部门名称不能为空</font>";
			return false;
		}
		if (menuMenuId == "" || menuMenuId == undefined || menuMenuId == null
				|| (menuMenuId.length > 0 && menuMenuId.trim().length == 0)) {
			document.getElementById("msgmenuMenuid").innerHTML = "<font  id='msgmenumenuid' color='red'>部门地点不能为空</font>";
			return false;
		}
		return true;
	} else {
		return false;
	}
}
function dismenuName() {
	if ($("#msgmenuname").length > 0) {
		$("#msgmenuname").remove();
	}
}
function dismenuMenuId() {
	if ($("#msgmenumenuid").length > 0) {
		$("#msgmenumenuid").remove();
	}
}
function dispass() {
	if ($("#pwd").length > 0) {
		$("#pwd").remove();
	}
}

function newpwd() {
	var newpass = $("#new").val();
	var pass = $("#yes").val();
	alert(newpass);
	alert(pass);
	if(pass!=null){
		if (newpass != pass) {
			document.getElementById("yespass").innerHTML = "<font id='yesp' color='red'>两次密码不一致</font>";
		}
	}
}
function level(tt){
	var regStrs = [ [ '^0(\\d+)$', '$1' ], // 禁止录入整数部分两位以上，但首位为0
		[ '[^\\d\\.]+$', '' ], // 禁止录入任何非数字和点
		for (i = 0; i < regStrs.length; i++) {
			var reg = new RegExp(regStrs[i][0]);
			th.value = th.value.replace(reg, regStrs[i][1]);
		}
}
