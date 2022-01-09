import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

 class Main {
		public static void main(String[] args) throws Exception {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder out = new StringBuilder();

			InetAddress ipv6 = java.net.Inet6Address.getByName(in.readLine().trim());
			for (String token : ipv6.getCanonicalHostName().split(":")) {
				out.append(String.format("%4s", token).replace(' ', '0')).append(':');
			}
			System.out.println(out.substring(0, out.length() - 1));
		}
	}

