package com.hemalatha.IK.strings;

public class PalindromicIndex {
}



/**
 function palindromeIndex( s )
 {
 const
 // We always use `slen - 1` so subtract `1` here
 slen = s.length - 1,

 /**
 * This is what use to compare strings. It doesn't require
 * us to copy, reverse, split, or substring anything because
 * those are all expensive operations and also unnecessary.
 *
 * @param {number} i
 * @param {number} j
 * @return {boolean}

        compare = ( i, j ) => {
				while ( i < j && s[ i ] === s[ j ] )
		{
		++i;
		--j;
		}

		return i >= j;
		};

		let result = -1;

		// Do we have a palindrome to begin with?
		if ( !compare( 0, slen ) )
		{
		// Left and right side indices
		let i = 0,
		j = slen;

		while ( i < j ) // When they cross, we're done
		{
		if ( s[ i ] !== s[ j ] )    // If we have a divergence
		{
		// Only compare what we didn't already compare
		if ( compare( i + 1, j ) )  // Check left skip
		result = i;
		else if ( compare( i, j - 1 ) ) // Check right skip
		result = j;

		break;
		}
		++i;
		--j;
		}
		}

		return result;
		}
		**/