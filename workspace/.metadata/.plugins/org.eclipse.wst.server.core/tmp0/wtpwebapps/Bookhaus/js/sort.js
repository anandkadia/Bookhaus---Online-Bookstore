$(function(){
	
	$('#sort-sel').change(function(){
		var selVal = $(this).val();
		
		if(selVal == 2)
		{
			$('#sort-container .sort-element').sort(function(a,b) {
				var priceA = parseFloat($(a).data('price')),
					priceB = parseFloat($(b).data('price'));
			     return priceA - priceB;
			}).appendTo('#sort-container');
		}	
		else if(selVal == 3)
		{
			$('#sort-container .sort-element').sort(function(a,b) {
				var priceA = parseFloat($(a).data('price')),
				priceB = parseFloat($(b).data('price'));
		     return priceB - priceA;
			}).appendTo('#sort-container');
		}
		else
		{
			//load relevance from the database
			window.location.reload();
		}
	});
	
});