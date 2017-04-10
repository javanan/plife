package com.jlife.sys.util;


import com.jlife.base.util.Digests;
import com.jlife.base.util.Encodes;
import com.jlife.base.util.JlifeUtils;
import com.jlife.sys.config.SysGlobal;

/**
 * Created by chenjianan on 2017/2/25-19:12.
 * <p>
 * Describe:
 */
public class SysApiUtils{
    /**
     * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
     */
    public static String entryptPassword(String plainPassword) {
        String plain = Encodes.unescapeHtml(plainPassword);
        byte[] salt = Digests.generateSalt(SysGlobal.SALT_SIZE);
        byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, SysGlobal.HASH_INTERATIONS);
        return Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword);
    }



}
