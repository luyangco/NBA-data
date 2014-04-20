$(document).ready(function() {

	// =========================================================================
	// TOGGLE SLIDE HEADER =====================================================
	// =========================================================================
	$('#tiny-toggle').click(function() {
		$('#tiny-nav ul').slideToggle();
		return false;
	});

	// =========================================================================
	// SEARCH BAR IN HEADER ====================================================
	// =========================================================================
	$('#search-button').click(function() {
		// get the width of header
		var hwidth  = $('header').width() - 100;

		// set the height and width for input
		$('#search input').width(hwidth + 'px');

		// show input and focus on it
		$('#search').fadeIn(150);
		$('#search input').focus();

		return false;
	});

	// header click out of giant search
	$('#search input').blur(function() {
		$('#search').fadeOut(150);
	});

	// Mobile Search
	$('#mobile-search').click(function() {
		$('.mobile-tagline').fadeOut(150);
		$('#mobile-search form input').focus();
		return false;
	});
	$('#mobile-search form input').blur(function() {
		$('#mobile-search form input').val('')
		$('.mobile-tagline').fadeIn(150);
	});

	// =========================================================================
	// TOOLTIPS ================================================================
	// =========================================================================
	$('#author-links a').tooltip();

	// =========================================================================
	// EQUAL HEIGHTS ARTICLES ==================================================
	// =========================================================================

	$('#quick-tips').equalize({ children: '.article-grid' });

	// main article row
	$('#main-article img').on('load', function() {
		var mainArticleHeight = $('#main-article').height();
		$('#info-box').innerHeight(mainArticleHeight);
	});

	// other article rows
	$('.article-row').each(function() {
		// get the heights of both articles
		var firstArticle  = $(this).children('.col-md-6:first-child').find('.article-grid-content');
		var secondArticle = $(this).children('.col-md-6:last-child').find('.article-grid-content');

		var firstHeight   = $(firstArticle).height();
		var secondHeight  = $(secondArticle).height();

		// set the articles to the taller article
		if (firstHeight > secondHeight)
			$(secondArticle).height(firstHeight + 'px');
		else
			$(firstArticle).height(secondHeight + 'px');
	});

	$(window).resize(function() {
		var mainArticleHeight = $('#main-article').height();
		$('#info-box').innerHeight(mainArticleHeight);

		// other article rows
		$('.article-row').each(function() {
			// get the heights of both articles
			var firstArticle  = $(this).children('.col-md-6:first-child').find('.article-grid-content');
			var secondArticle = $(this).children('.col-md-6:last-child').find('.article-grid-content');

			var firstHeight   = $(firstArticle).height();
			var secondHeight  = $(secondArticle).height();

			// set the articles to the taller article
			if (firstHeight > secondHeight)
				$(secondArticle).height(firstHeight + 'px');
			else
				$(firstArticle).height(secondHeight + 'px');
		});
	});
	
	
	// =========================================================================
	// CONSOLE COOL ============================================================
	// =========================================================================
	if (!$('body').hasClass('single')) {
	  console.log("%cWelcome to Scotch", "color: #F4C600; font-size: x-large; text-transform: uppercase; background: #362E2A; padding: 2px 90px; border-radius: 20px;");
	  console.image("http://i.imgur.com/oGiMR.gif");
	}

	// =========================================================================
	// SINGLE PAGE SOCIAL ======================================================
	// =========================================================================
	$(window).scroll(function() {
		var offset = $(window).scrollTop();
		offset     = offset * 4;

		$('.share-links li a i').css({
			'-moz-transform': 'rotate(' + offset + 'deg)',
			'-webkit-transform': 'rotate(' + offset + 'deg)',
			'-o-transform': 'rotate(' + offset + 'deg)',
			'-ms-transform': 'rotate(' + offset + 'deg)',
			'transform': 'rotate(' + offset + 'deg)',
		});
	});

	// =========================================================================
	// SOCIAL NUMBERS COUNT ====================================================
	// =========================================================================
	$('.social-number').each(function() {
		var number = parseInt($(this).html(), 10);

		$(this).data('count', parseInt($(this).html(), 10));
		$(this).html('0');
		if (number != 0)
			count($(this));
	});

	// =========================================================================
	// Page Specific Custom ====================================================
	// =========================================================================
	if ($('#emoji-table').length > 0) {
		$.ajax({
			url 		: 'https://api.github.com/emojis?callback=callback',
			type 		: 'GET',
			dataType 	: 'jsonp',
			success 	: function(data) {
				$.each(data.data, function( index, value ) {
					$('#emoji-table tbody').append('<tr><td><span class="text-danger">:'+index+':</span></td><td><img src="'+value+'"></td></tr>')
				});
			},
			error 		: function(data) {
				console.log(data);
			}
		});
	}
	if ($('.fixed-width-site img').length > 0) {
		$(".fixed-width-site img").hover(
		   function() {
		   		$(this).attr('data-old', $(this).attr('src'));
		     	$(this).attr('src', $(this).data('swapper'));
		   },
		   function() {
		      $(this).attr('src', $(this).data('old'));
		   }
		) 
	};
	if ($('body').hasClass('category')) {
		$('#pagination-links a').click(function() {
			var href = $(this).attr('href');
			
			href = href.replace('category/', '');

			href = href.replace('.io/', '.io/category/');
			href = href.replace('.local/', '.local/category/'); // ghetto rules!


			window.location.href = href;

			return false;
		});
	}

});

function count($this) {
	var current = parseInt($this.html(), 10);
	$this.html(++current);

	if(current !== $this.data('count')) {
		setTimeout(function() {
			count($this)
		}, 50);
	}
}