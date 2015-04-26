$(function(){
	
	$('#basic-search-form').submit(function(){
		
		if(!($(this).find('[name="searchTokens"]').val().trim()))
		{
			return false;
		}
		else
		{
			return true;
		}	
	});
});