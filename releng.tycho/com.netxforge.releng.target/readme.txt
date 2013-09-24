- The local target should not be checked in, but used for easy management 
and migration to a full P2 URL .target (Plugins can be compared in case of compilation/runtime errors). 

- The shared (Stored) target is based on Eclipse simulteanous releases.

- Includes HTTP Repo's as much as possible. 

- Some local repo's also, will expose through our Apache Server as HTTP URL's. 

netxstudio_kepler.local.target => Local target for Kepler, points to local directories. (Is not a shared target). 
netxstudio_kepler.target => Base target for Kepler, can be used by build system. 
netxstudio_kepler_dtp.target => Target for Kepler with DTP and BiRT for building a reporting enabled version. 
netxstudio_kepler_git.target => TODO Target with GIS support (GeoFF). 

 