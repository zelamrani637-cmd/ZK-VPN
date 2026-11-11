
# ZK VPN — Android starter

This is a minimal Android project scaffold for browser-based GitHub Actions builds.

## Current functionality
- Displays a basic ZK VPN screen.
- Accepts a `vless://` link and checks/parses its basic fields.
- Includes a placeholder Android `VpnService` declaration.

## Important limitation
This starter does **not** establish a VPN tunnel and does **not** include Xray-core/libXray. A successful APK build only confirms that the Android project compiles; it does not mean VPN connectivity works.

## Build
Push the repository to GitHub. The workflow at `.github/workflows/android.yml` builds a debug APK on each push to `main`/`master`, and when manually run from Actions.

Download the artifact named `ZK-VPN-debug-apk` from the completed workflow run.
