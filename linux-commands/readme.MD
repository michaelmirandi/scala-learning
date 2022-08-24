- Tar is a archiving tool, a tarball is created. Can be compressed or uncompressed.

Create tarball
```
tar cf example.tar *.ts
```

List contents of tarball
```
tar tf example.tar
```

Unpack tarball
```
tar xf example.tar
```

Create compressed tarball
```
tar czf example.tar *.ts
```

Unpack and expand compressed tarball
```
tar xzf example.tar
```

- Remote Connections

Tap into command line on remote machine
```
ssh <remote-directory-here>
```

Copy files from remote to local, and vice versa
```
scp <from> <to>
```

- I/O Redirection

Overwrite file / foldercat
```
ls -l > files.txt
```

Overwrite file / folder
```
ls -l >> files.txt
```

Write into variable
```
cat < files.txt
```