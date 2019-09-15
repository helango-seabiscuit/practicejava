package com.hemalatha.IK.adhoc;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by helangovan on 4/10/17.
 */
public class Throwaway {

    public static void main(String[] args) throws Exception {
        String bankDocNotAsAgreementDateString ="2017-03-10 00:00:00-0800";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        Date date = sdf.parse(bankDocNotAsAgreementDateString);

    }
}
