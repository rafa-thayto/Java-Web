<%@ attribute name="id" required="true"%>
<%@ attribute name="value" required="false"%>

<input id="${id }" name="${id }" value="${value }" />

<script>
	$("#${id}").datepicker({
		dateFormat : 'dd/mm/yy', changeYear: true
	});
	$("#${value}").datepicker({
		dateFormat : 'dd/mm/yy', changeYear: true
	});
</script>