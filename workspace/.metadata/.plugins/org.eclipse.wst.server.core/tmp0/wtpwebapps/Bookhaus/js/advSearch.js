$(function(){
	
	var artistListData =  $.makeArray($('#artistListData span').map(function(index, domEl){ return $(domEl).text();})),
	publisherListData =  $.makeArray($('#publisherListData span').map(function(index, domEl){ return $(domEl).text();})),
	authorListData =  $.makeArray($('#authorListData span').map(function(index, domEl){ return $(domEl).text();}));
	
	$('#adv-search-dropdown .dropdown-menu a').click(function(){
		$('#adv-search-dropdown .selected-item').text($(this).text());
		$('#my-tab-content .tab-pane').removeClass('active');
		$($(this).attr('href')).addClass('active');
		$('#adv-search-dropdown').removeClass('open');
		return false;
	});
	
	$("#artist").autocomplete({source: artistListData, minLength: 2});
	
	$("#publisher").autocomplete({source: publisherListData, minLength: 2});
	
	$("#author").autocomplete({source: authorListData, minLength: 2});
	
	$("#booksPriceFilter, #booksYearFilter, #musicPriceFilter, #musicYearFilter, #suppliesPriceFilter, #accessPriceFilter").slider({});
	
	$("#booksPriceFilter, #musicPriceFilter, #suppliesPriceFilter, #accessPriceFilter").on('slide', function(slideEvt) {
		$(this).parent().prev().text('$'+slideEvt.value[0]);
		$(this).parent().next().text('$'+slideEvt.value[1]);
		$($(this).data('input')).val(slideEvt.value.join('-'));
	});
	
	$("#musicYearFilter").on('slide', function(slideEvt) {
		$(this).parent().prev().text(slideEvt.value[0]);
		$(this).parent().next().text(slideEvt.value[1]);
		$($(this).data('input')).val(slideEvt.value.join('-'));
	});
	
	$("#booksYearFilter").on('slide', function(slideEvt) {
		$(this).parent().prev().text(slideEvt.value[0]);
		$(this).parent().next().text(slideEvt.value[1]);
		$($(this).data('input')).val(slideEvt.value[0] + '-01-01_' + slideEvt.value[1] + '-01-01');
	});
	
	$('#isbn').keyup(function(){
		$('#title, #author, #publisher, #booksPrice, #booksYear, #genre, #description').val('');
		
	});
	
	$('#title, #author, #publisher, #description').keyup(function(){
		$('#isbn').val('');
	});
	
	$('#price, #genre').change(function(){
		$('#isbn').val('');
	});
	
	$('form[action="AdvanceSearch"]').submit(function(){
		var sort1 = $(this).find('select[name="sortBy1"]').val(), 
		sort2 = $(this).find('select[name="sortBy2"]').val(),
		sort3 = $(this).find('select[name="sortBy3"]').val(),
		sortOrder = $(this).find('input[name="sortOrder"]'),
		sort = '';
		
		if(sort1)
		{
			sort += sort1;
		}

		if(sort2)
		{
			sort = sort + ', ' + sort2;
		}
		
		if(sort3)
		{
			sort = sort + ', ' + sort3;
		}
		
		sortOrder.val(sort);
		
	});
	
});