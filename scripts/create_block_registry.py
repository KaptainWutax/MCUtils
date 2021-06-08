from collections import defaultdict, OrderedDict
from pathlib import Path

from future.moves import sys

p = Path(r'.').glob('blocks/*.txt')
files = [x for x in p if x.is_file()]
files.sort()
d = defaultdict(OrderedDict)
for file in files:
    with open(file) as f:
        for line in f.readlines():
            line = line.strip()
            n, id, name = line.split(",")
            d[n][file.stem] = [id, name]


def stringify(s):
    return "".join([e[0].upper() + e[1:].lower() for e in s.split("_")])


MAX_PER_FILE = 300
CURRENT_FILE=1
FILE=None
for idx, (block, v) in enumerate(d.items()):
    latest_name = None
    latest_id = None
    ids = []
    names = []
    implemented_version = None
    for version, data in v.items():
        if implemented_version is None:
            implemented_version = version
        if latest_id != data[0]:
            latest_id = data[0]
            ids.append((version, latest_id))
        if latest_name != data[1]:
            latest_name = data[1]
            names.append((version, latest_name))
    if implemented_version is None:
        print("Missing at least a version for", block)
        sys.exit(-1)
    if (idx%MAX_PER_FILE)==0:
        if FILE is not None:
            FILE.write("}")
            FILE.close()
        FILE=open("Function"+str(CURRENT_FILE)+".java","w")
        FILE.write(f"""package kaptainwutax.mcutils.block.blocks;

import kaptainwutax.mcutils.block.Block;
import kaptainwutax.mcutils.util.data.Pair;
import kaptainwutax.mcutils.version.MCVersion;

import static kaptainwutax.mcutils.block.Blocks.register;

@SuppressWarnings("unchecked")
public class Function{CURRENT_FILE}{{
""")
        CURRENT_FILE+=1
    # s = f"\tpublic static final Block {block} = " \
    s = f"\tpublic static Block {stringify(block)}() {{\n\t\treturn register(MCVersion.{implemented_version},\n\t\t\tnew Pair[] {{\n"
    for (idx, (version, id)) in enumerate(ids):
        s += f"\t\t\t\tnew Pair<>(MCVersion.{version}, {id}){',' if idx != len(ids) - 1 else ''}\n"
    s += "\t\t\t},\n\t\t\tnew Pair[] {\n"
    for (idx, (version, name)) in enumerate(names):
        s += f"\t\t\t\tnew Pair<>(MCVersion.{version}, \"{name}\"){',' if idx != len(ids) - 1 else ''}\n"
    s += "\t\t\t}\n\t\t);\n\t}\n"
    FILE.write(s)
if FILE is not None:
    FILE.write("}")
    FILE.close()
for idx, (block, v) in enumerate(d.items()):
    s=f"\t\tpublic static final Block {block} = {stringify(block)}();"
    print(s)
