def response = '''Filesystem             Size   Used  Available Capacity  Mounted on
rpool/ROOT/solaris      20G    13G       4.7G    74%    /
/dev                     0K     0K         0K     0%    /dev
/oracle                 15G   6.0G       8.6G    42%    /oracle
/sapmnt                 15G   6.0G       8.6G    42%    /sapmnt
/usr/sap                15G   6.0G       8.6G    42%    /usr/sap
rpool/ROOT/solaris/var
                        15G   924M       4.7G    17%    /var
proc                     0K     0K         0K     0%    /proc
ctfs                     0K     0K         0K     0%    /system/contract
mnttab                   0K     0K         0K     0%    /etc/mnttab
objfs                    0K     0K         0K     0%    /system/object
swap                   256G    73G       183G    29%    /system/volatile
sharefs                  0K     0K         0K     0%    /etc/dfs/sharetab
fd                       0K     0K         0K     0%    /dev/fd
swap                   256G    73G       183G    29%    /tmp
rpool/VARSHARE          84G    36M        66G     1%    /var/share
rpool/export            20G    32K        17G     1%    /export
rpool/export/home       20G    69K        17G     1%    /export/home
rpool/export/home/chawalit
                        20G   2.8G        17G    14%    /export/home/chawalit
rpool/export/home/dr1adm
                        20G   124K        17G     1%    /export/home/dr1adm
rpool/export/home/kanathip
                        20G    35K        17G     1%    /export/home/kanathip
rpool/export/home/komeshch
                        20G    44K        17G     1%    /export/home/komeshch
rpool/export/home/manusnun
                        20G    31K        17G     1%    /export/home/manusnun
rpool/export/home/nattaphon
                        20G    43K        17G     1%    /export/home/nattaphon
rpool/export/home/panupongba
                        20G    35K        17G     1%    /export/home/panupongba
rpool/export/home/pattarapongie
                        20G    38K        17G     1%    /export/home/pattarapong
rpool/export/home/rujira
                        20G    46K        17G     1%    /export/home/rujira
rpool/export/home/sapadm
                        20G    35K        17G     1%    /export/home/sapadm
rpool/export/home/sapita
                        20G    53K        17G     1%    /export/home/sapita
rpool/export/home/sapmon
                        20G    83K        17G     1%    /export/home/sapmon
rpool/export/home/suwatchai
                        20G    36K        17G     1%    /export/home/suwatchai
rpool/export/home/teintongsi
                        20G    37K        17G     1%    /export/home/teintongsi
rpool/export/home/waranyoo
                        20G    31K        17G     1%    /export/home/waranyoo
rpool/export/home/warit
                        20G   2.7M        17G     1%    /export/home/warit
rpool/export/home/wichaipa
                        20G    35K        17G     1%    /export/home/wichaipa
rpool                   84G    31K        66G     1%    /rpool
usr-sap-PRD            109G    43G        66G    40%    /usr/sap/PRD
192.168.150.36:/export/PRD-Interface
                       500G   443G        57G    89%    /interface
192.168.150.36:/export/PRD-PBS
                       150G    65G        85G    44%    /pbs
192.168.150.36:/export/PRD-sapmnt-PRD
                       200G   115G        85G    58%    /sapmnt/PRD
192.168.150.36:/export/PRD-usr-sap-trans	
                       100G    18G        82G    18%    /usr/sap/trans
10.118.5.97:/SAP       400G   241G       159G    61%    /ffm
10.76.57.32:/EdocInput
                       836G   312G       524G    38%    /EdocInput
10.10.222.238:/export/bck-sap-parameter
                       100G   1.0M       100G     1%    /bck-sap-parameter
192.168.225.157:/nfs/interface/ecc
                       1.0T    22G      1002G     3%    /interface/ecc
rpool/export/home/sccadm
                        20G    53K        17G     1%    /export/home/sccadm
10.10.222.238:/export/interface-migration-PRD
                       250G   4.3G       246G     2%    /interface/MIGRATION
 '''

def ethNetLine = "";

response.eachLine{
	if (it.contains("80%")) {
	 println it
	 ethNetLine += it  + "\n"
	 
	}

}