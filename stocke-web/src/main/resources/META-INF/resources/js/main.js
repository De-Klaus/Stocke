function expandFilter(){
	$(".filterTable").show();
	$('#expandFilterMenu').hide();
	$('#collapseFilterMenu').show();
}

function collapseFilter(){
	$(".filterTable").hide();
	$('#collapseFilterMenu').hide();
	$('#expandFilterMenu').show();
}

function scrollY() {
	var de = document.documentElement;
	return self.pageYOffset ||( de && de.scrollTop ) || document.body.scrollTop;
}

function scrollX() {
	var de = document.documentElement;
	return self.pageXOffset || ( de && de.scrollLeft ) || document.body.scrollLeft;
}

var showserviceerror = function() {
    $("#errorDiv").toggle();
}

var position = function(){
	var $el = $('#waitindicator');
	if (!$el) {
		console.log("Waitindicator not found!");
		return;
	}
	$el.show();
	var width = $el.width();
	var height = $el.height();
	var t = scrollY() + ( ($(window).height() / 2 - 40)  -  height / 2 );
	if ( t < 0 ) t = 0;
	var l = scrollX() + ( ($(window).width() / 2 - 60)  -  width / 2 );
	if ( l < 0 ) l = 0;
	$el.css({ 
		left: l, 
		top: t
	});	
}

var disablePage = function () {
		var $div = $('<div id="wait"></div>');
		var scrW = document.body.scrollWidth;
		var scrH = document.body.scrollHeight;
		var winW = $(window).width();
		var winH = $(window).height();
		$div.css({
			display: 'none',
			position: 'absolute',
			width: (scrW > winW ? scrW : winW ),
			height: (scrH > winH ? scrH : winH ),
			opacity: 0.6,
			'z-index': 99999,
			'background-color': '#999999'
		});
		$('body').prepend($div);
		if ($.browser.opera){
			$div.show();
			position();
		} else {
			$div.fadeIn('2000', function(){
				position();
			});	
		}
		window.onresize = document.onscroll = position;
} 

//Проверка ИНН на правильность в соответствии со стандартом
function checkInnUI(val){
	if (val.length == 10 && val.match(/^\d+$/)){
		var n1 = parseInt(val.charAt(0));
		var n2 = parseInt(val.charAt(1));
		var n3 = parseInt(val.charAt(2));
		var n4 = parseInt(val.charAt(3));
		var n5 = parseInt(val.charAt(4));
		var n6 = parseInt(val.charAt(5));
		var n7 = parseInt(val.charAt(6));
		var n8 = parseInt(val.charAt(7));
		var n9 = parseInt(val.charAt(8));
		var n10 = parseInt(val.charAt(9));
		
		var control = ((2*n1 + 4*n2 + 10*n3 + 3*n4 + 5*n5 + 9*n6 + 4*n7 + 6*n8 + 8*n9) % 11) % 10;
		if (control != n10)
			return false;
		return true;
	}
}

//Проверка числовых полей (кпп, номер счета) на соответствие стандарту
function checkLengthofDigitsFields(val, len){
	if (val == '')
		return false;
	if (val.length != len)
		return false;
	if (!val.match(/^\d+$/))
		return false;
	return true;
	
}

function checkPhoneNumber(val){
	if(val == '') return true;
	var arr = val.split(',');
	var regexp = /^\d{10}$/;
	var index;
	for (index = 0; index < arr.length; ++index) {
	    if(!regexp.test(arr[index])){
	    	return false
	    }
	}
	return true;
}

function isValidDate(subject){
	  if (subject.match(/^(?:(0[1-9]|1[012])[\- \/.](0[1-9]|[12][0-9]|3[01])[\- \/.](19|20)[0-9]{2})$/)){
	    allert("Lol");
	  }else{
	    allert("Lol");
	  }
	}

//Проверка обязательных полей
function checkRequiredField(val){
	var result=true;
	
	if (val == '' || val==null){
		result=false;
	}
	
	return result;
}

//Проверка правильности заполнения номеров документов
function checkStringByRegExp(val, regexp){
	if (val == '')
		return false;
	if (regexp == '')
		return true;
	if (!val.match(regexp))
		return false;
	
	return true;
}



//Проверка правильности заполнения номеров документов
function checkStringByRegExp(val, pattern, flags){
	var expr = new RegExp(pattern, flags);
	return val.match(expr)!=null;
}

//Загружает аджаксом УРЛ в Див
function ajaxInDiv(context, divName, url, makeFlash) {
	/* $("#" + divName).html(''); */
	var $img = $('<img src="' + context + '/img/loading_indicator.gif"/>');
	$img.css({
		display: 'none',
	});
	
	$('#' + divName).children().fadeTo( "fast" , 0);

	if (1 == 2) {
		$('#' + divName).prepend($img);
		$img.fadeIn('2000');
	}

	$.ajax({
		url : url,
		cache : false,
		complete : function(html) {
		},
		error : function() {
			$("#" + divName).html('<span style=" color: red; " >no connection</span>');
		}
	}).done(function(html) {
		$("#" + divName).html(html);
		$('#' + divName).fadeTo( "fast" , 1);
		if (makeFlash) {
			$('#' + divName).effect("highlight", {color: '#FFFFFF'}, 1000);
		}
	});

	return false;
}

// Переводит окно на УРЛ с затемнением
function moveToUrl(url) {
	disablePage();
	window.location = url;
}
/**
 * Открыть popup-window
 * @param url
 * @param title
 * @returns
 */
function editEntity(url,title,id,width,heigtht){
	
	var maxWidth = width ? width : window.width*0.70;
	var maxHeight = heigtht ? heigtht : window.height*0.70;
	var wnd = Liferay.Util.openWindow(
	{
		dialog:{
			modal: true,
			resizable: false,
			destroyOnClose: true,
			destroyOnHide: true,
			centered: true,
			height: maxHeight,
			width: maxWidth
		},
		dialogIframe: {
			bodyCssClass: 'dialog',
		},
		id: id,
		title: title,
		uri:url
	});
}

function initInputMasks() {
	AUI().use('aui-datepicker', function(A){
		new A.DatePicker({
			trigger: '.datepicker',
			mask: '%d.%m.%Y',		
			popover: {
	          zIndex: 1000
	        },
	        after: {
	        	selectionChange: function(event) {
	       			var input = this.get('activeInput');
	       			formValidator = Liferay.Form.get(input.ancestor('form').getAttribute('id')).formValidator;		
	    			formValidator.validateField(input.getAttribute('name'));
	        	}
	        }        
		});
		new A.DatePicker({
			trigger: '.datepicker-min',
			mask: '%d.%m.%Y',
			calendar: {
		        minimumDate: new Date()
		    },
			popover: {
	          zIndex: 1000
	        },
	        after: {
	        	selectionChange: function(event) {       		    
	        			var input = this.get('activeInput');
	        			formValidator = Liferay.Form.get(input.ancestor('form').getAttribute('id')).formValidator;		
	        			formValidator.validateField(input.getAttribute('name'));     	
	        	}
	        }
		});

	});		
	}
	$(function () {
		initInputMasks();
		$(":text").inputmask();
	});

	function clearFilter(nameSpace) {
		AUI().use(['aui-base','aui-node'], function(A){
			var formFiltr = A.one("#"+nameSpace+"filterForm");			
			formFiltr.all(':text').each(function(node){
				A.one(node).val('');
			});
			formFiltr.all('select').each(function(node){
				A.one(node).val('0');
			});
			formFiltr.all('input[type=checkbox]').each(function(node){
				A.one(node).set('checked',false);
			});
			submitForm(formFiltr);
		});			     
	}
	function changeActionAndSubmitForm(formId, action){
		AUI().use('aui-base', function(A){
			var form=A.one('#'+formId);		
			if (form){
				form.attr('action',action);
				try{
					formValidator = Liferay.Form.get(formId).formValidator;				
					formValidator.validate();
					if(formValidator.hasErrors()){
						return;
					}				
				} catch (e) {
				}
				submitForm(form);
			}
		});
	}

	function closeDialogAndSubmit(dialogId,data){
		AUI().use(function (A) {	
		var form = A.one('#'+data);
		Liferay.Util.getOpener().closeDialogSubmit(dialogId,form); 
			});
		
	}

function toggle(id) {
	const element = document.getElementById(id);
	if (element) {
		if (element.className.indexOf('d-none') === -1)
			element.className = 'd-none';
		else
			element.className = '';
	}
}

function applyAction(url,formId) {
	if (formId) {
		var form = document.forms[formId];
		form.action=url;
		form.submit();
	} else
		window.location.href=url;
}


/*
 Открытие окна Liferay
 - url - ссылка, которая откроется в созданном окне
 - title - заголовок окна
 */
function openForm(url,title) {
	Liferay.Util.openWindow(
		{
			dialog: {
				centered : true,
				modal: true,
				destroyOnHide: true
			},
			id: 'entityItem',
			dialogIframe: {},
			title: title,
			uri: url
		}
	)
}
/*
 Закрытие окна Liferay
 */
function closeForm() {
	var dialog = Liferay.Util.getTop().Liferay.Util.Window.getById('entityItem');
	console.log('DIALOG '+dialog)
	if(dialog!=null)
		dialog.destroy();
	window.location.reload();
}

/* ajax-отправка данных формы с использованием Liferay.Util.fetch, тип запроса POST
- formId - форма, которую нужно отправить на сервер,
- url - ссылка,
- errorContainer - div-контейнер, в который будут выведены ошибки от сервера
- errorText - текст ошибки при внутренней ошибке со стороны сервера
- callback - функция, которая будет вызвана после успешного выполнения
*/
function sendFormByAjax(formId,url,errorContainerArray,errorText,callback) {
	 console.log('FORM BY AJAX ' + formId + ";2 "+url+";3 "+errorContainerArray+";4 "+errorText+";5 "+callback);
	Liferay.Util.fetch(url, {
		body: new FormData(document.forms[formId]),
		method: 'POST'
	}).then(function(response) {
		console.log('sendFormByAjax 2');
		return response.json();
	}).then(callback).catch(function(e) {
		console.log('sendFormByAjax 3');
		viewErrors([errorContainerArray],[errorText]);
		console.log('sendFormByAjax 4');
		console.log(e);
		console.log('sendFormByAjax 5');
	});
}

/* Отображение ошибок в div-контейнере (создается заранее)
- container - div-контейнер, в который будут выведены ошибки от сервера
- errorArray - массив строк с ошибками
*/
function viewErrors(containerArray,errorArray) {
	console.log('viewErrors 1');
	for (var i=0;i<containerArray.length;i++) {
		console.log('viewErrors 2');
		var container = document.getElementById(containerArray[i]);
		console.log('viewErrors 3');
		if (!container)
			return;
		console.log('viewErrors 4');
		containerArray[i].innerHTML = '';
		console.log('viewErrors 5');
		var div = document.createElement("DIV");
		console.log('viewErrors 6');
		div.className = "alert alert-danger alert-form-content";
		console.log('viewErrors 7');
		div.innerHTML = errorArray[i];
		console.log('viewErrors 8');
		container.appendChild(div);
		console.log('viewErrors 9');
		window.location.hash = '#' + containerArray[i];
		console.log('viewErrors 10');
	}
}


