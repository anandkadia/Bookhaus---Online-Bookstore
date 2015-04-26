$(function(){
	
	$('#categoryTabs a').click(function(event){
		var cat = $(this).data('category-select'),
			catItems = $('#categoryItems [data-category="'+ cat +'"]');
		$('#categoryTabs li').removeClass('active');
		$(this).parent().addClass('active');
		
		if(cat === 'All')
		{
			var allItems = $('#categoryItems [data-category]');
			
			if(allItems.length)
			{
				$('#categoryItems').addClass('active');
				$('#noResult').removeClass('active');
				$('.sort-form').show();
				$('#categoryItems [data-category]').show();
			}
			else
			{
				$('#categoryItems').removeClass('active');
				$('#noResult').addClass('active');
				$('.sort-form').hide();
			}
		}
		else 
		{
			if(catItems.length)
			{
				$('#categoryItems').addClass('active');
				$('#noResult').removeClass('active');
				$('.sort-form').show();
				$('#categoryItems [data-category]').hide();
				catItems.show();
			}
			else
			{
				$('#categoryItems').removeClass('active');
				$('#noResult').addClass('active');
				$('.sort-form').hide();
			}	
		}
		
		return false;
	});
	
	
	$('#categoryTabs a[data-category-select="All"]').trigger('click');
	
});