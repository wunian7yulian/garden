package com.lynwood.g.base.rock.web.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;


public class IPUtils {
    public static IPUtils ipUtils=null;
    
	private IPUtils() {
	}
	
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		String[] ipArray = ip.split(",");
		if (ipArray.length > 1) {
			for (int i = 0; i < ipArray.length; i++) {
				if (!ipArray[i].equalsIgnoreCase("unknown")) {
					ip = ipArray[i];
					break;
				}
			}
		}
		return ip;
	}
	
	/**
     * 读取本机公网Ip
     * 
     * @return
     * @throws SocketException
     */
    public static String getRealIp() {
        // 本地IP，如果没有配置外网IP则返回它
        String localip = "";
        // 外网IP
        String netip = "";

        Enumeration<NetworkInterface> netInterfaces;
        try {
            netInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            // 是否找到外网IP
            boolean finded = false;
            while (netInterfaces.hasMoreElements() && !finded) {
                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> address = ni.getInetAddresses();
                while (address.hasMoreElements()) {
                    ip = address.nextElement();
                    if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
                        // 外网IP
                        netip = ip.getHostAddress();
                        finded = true;
                        break;
                    } else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
                        && ip.getHostAddress().indexOf(":") == -1) {
                        // 内网IP
                        localip = ip.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            // TODO Auto-generated catch block
             e.printStackTrace();
        }

        if (netip != null && !"".equals(netip)) {
            return netip;
        } else {
            return localip;
        }
    }
	
}
