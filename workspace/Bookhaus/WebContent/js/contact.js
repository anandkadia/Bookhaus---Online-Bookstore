$(function() {

	var map, marker;

	function initialize() 
	{
		map = new google.maps.Map($('#map-canvas')[0],
				{
					center : new google.maps.LatLng(32.733600, -97.109311),
					zoom : 15
				});
		$('.locate-link:first').trigger('click');
	}

   function setMarker(lat, lng, title) 
   {
        var bounds = new google.maps.LatLngBounds(),
        latLng = new google.maps.LatLng(lat, lng);
        
        marker = new google.maps.Marker({
            position: latLng,
            map: map,
            title: title
        });
        
        bounds.extend(latLng);

        map.setCenter(bounds.getCenter());
    }

    function clearMarker() 
    {
    	if(marker)
    	{
    		marker.setMap(null);
    	}	
    }
    
    $('.locate-link').click(function(){
    	var lat = $(this).data('latitude'),
    		lng = $(this).data('longitude'),
    		title = $(this).data('title');
    	
    	clearMarker();
    	setMarker(lat, lng, title);
    	$('#store-showing').text('Showing ' + title + ' on the map');
    	return false;
    });
    
    
    //load Google Map on startup
    google.maps.event.addDomListener(window, 'load', initialize);
});